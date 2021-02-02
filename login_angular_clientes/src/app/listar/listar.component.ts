import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {DataService} from '../services/data.service';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Cliente} from '../models/cliente';
import {DataSource} from '@angular/cdk/collections';
import {AgregarClienteComponent} from '../acciones/agregar/agregar.cliente.component';
import {EditarClienteComponent} from '../acciones/editar/editar.cliente.component';
import {BorrarClienteComponent} from '../acciones/borrar/borrar.cliente.component';
import {BehaviorSubject, fromEvent, merge, Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-listar-component',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})

export class ListarComponent implements OnInit {


  /*
  tpaId: number;
  tapDescripcion: string;
  tpaCausaEstatus: string;
  tpaEstatus: number;
  tpaFHAlta: string;
  tpaFHEstatus: string;
  tpaFHModifica: string;
  tpaObservaciones: string;
  tpaUsuAlta: string;
  tpaUsuModifica: string;*/


  displayedColumns = ['tpaId', 'tapDescripcion', 'tpaUsuAlta', 'tpaCausaEstatus','tpaObservaciones'];
  exampleDatabase: DataService | null;
  dataSource: ExampleDataSource | null;
  index: number;
  id: number;

  constructor(public httpClient: HttpClient,
              public dialog: MatDialog,
              public dataService: DataService) {}

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild('filter',  {static: true}) filter: ElementRef;

  ngOnInit() {
    this.loadData();
  }

  refrescar() {
    this.loadData();
  }

  /*addNew() {
    const dialogRef = this.dialog.open(AgregarClienteComponent, {
      data: {cliente: Cliente }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === 1) {
        // After dialog is closed we're doing frontend updates
        // For add we're just pushing a new row inside DataService
        this.exampleDatabase.dataChange.value.push(this.dataService.getDialogData());
        this.ngOnInit();
      }
    });
    this.ngOnInit();
  }*/

  /*startEdit(i: number, id: number, nombre: string, apellidoPaterno: string, apellidoMaterno: string, fechaNacimiento: string, ingresos: string, codigoPostal: string) {
    this.id = id;
    this.index = i;
    const dialogRef = this.dialog.open(EditarClienteComponent, {
      data: {id: id, nombre: nombre, apellidoPaterno: apellidoPaterno, apellidoMaterno: apellidoMaterno, fechaNacimiento: fechaNacimiento, ingresos: ingresos, codigoPostal:codigoPostal}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === 1) {
        // When using an edit things are little different, firstly we find record inside DataService by id
        const foundIndex = this.exampleDatabase.dataChange.value.findIndex(x => x.id === this.id);
        // Then you update that record using data from dialogData (values you enetered)
        this.exampleDatabase.dataChange.value[foundIndex] = this.dataService.getDialogData();
 
         this.ngOnInit();
      }
    });
  }*/

  /*deleteItem(i: number, id: number, nombre: string, apellidoPaterno: string, apellidoMaterno: string, fechaNacimiento: string, ingresos: string, codigoPostal: string) {
    this.index = i;
    this.id = id;
    const dialogRef = this.dialog.open(BorrarClienteComponent, {
      data: {id: id, nombre: nombre, apellidoPaterno: apellidoPaterno, apellidoMaterno: apellidoMaterno, fechaNacimiento: fechaNacimiento, ingresos: ingresos, codigoPostal:codigoPostal}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === 1) {
        const foundIndex = this.exampleDatabase.dataChange.value.findIndex(x => x.id === this.id);
        this.exampleDatabase.dataChange.value.splice(foundIndex, 1);
        this.refrescarTabla();
      }
    });
  }


  private refrescarTabla() {
    this.paginator._changePageSize(this.paginator.pageSize);
  }*/



  public loadData() {
    this.exampleDatabase = new DataService(this.httpClient);
    this.dataSource = new ExampleDataSource(this.exampleDatabase, this.paginator, this.sort);
    fromEvent(this.filter.nativeElement, 'keyup')
      .subscribe(() => {
        if (!this.dataSource) {
          return;
        }
        this.dataSource.filter = this.filter.nativeElement.value;
      });
  }
}

export class ExampleDataSource extends DataSource<Cliente> {
  _filterChange = new BehaviorSubject('');

  get filter(): string {
    return this._filterChange.value;
  }

  set filter(filter: string) {
    this._filterChange.next(filter);
  }

  filteredData: Cliente[] = [];
  renderedData: Cliente[] = [];

  constructor(public _exampleDatabase: DataService,
              public _paginator: MatPaginator,
              public _sort: MatSort) {
    super();
    this._filterChange.subscribe(() => this._paginator.pageIndex = 0);
  }


  connect(): Observable<Cliente[]> {

    const displayDataChanges = [
      this._exampleDatabase.dataChange,
      this._sort.sortChange,
      this._filterChange,
      this._paginator.page
    ];

    this._exampleDatabase.getClientes();


    return merge(...displayDataChanges).pipe(map( () => {
        this.filteredData = this._exampleDatabase.data.slice().filter((cliente: Cliente) => {
          if(cliente!==undefined){
          const searchStr = (cliente.tpaId);
          let toStringVar = searchStr.toString();
          return toStringVar.indexOf(this.filter.toLowerCase()) !== -1;
          }
        });
        const sortedData = this.sortData(this.filteredData.slice());
        const startIndex = this._paginator.pageIndex * this._paginator.pageSize;
        this.renderedData = sortedData.splice(startIndex, this._paginator.pageSize);
        return this.renderedData;
      }
    ));
  }

  disconnect() {}

  sortData(data: Cliente[]): Cliente[] {
    if (!this._sort.active || this._sort.direction === '') {
      return data;
    }

    return data.sort((a, b) => {
      let propertyA: number | string = '';
      let propertyB: number | string = '';

      switch (this._sort.active) {
        case 'id': [propertyA, propertyB] = [a.tpaId, b.tpaId]; break;
        case 'descripcion': [propertyA, propertyB] = [a.tapDescripcion, b.tapDescripcion]; break;
        case 'usuarioAlta': [propertyA, propertyB] = [a.tpaUsuAlta, b.tpaUsuAlta]; break;
        case 'causaEstatus': [propertyA, propertyB] = [a.tpaCausaEstatus, b.tpaCausaEstatus]; break;
        case 'observaciones': [propertyA, propertyB] = [a.tpaObservaciones, b.tpaObservaciones]; break;
      
      }


      const valueA = isNaN(+propertyA) ? propertyA : +propertyA;
      const valueB = isNaN(+propertyB) ? propertyB : +propertyB;

      return (valueA < valueB ? -1 : 1) * (this._sort.direction === 'asc' ? 1 : -1);
    });
  }
}
