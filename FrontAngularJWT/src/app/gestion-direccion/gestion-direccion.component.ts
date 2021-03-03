import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { DireccionService } from '../services/direccion.service';
import { Direccion } from '../models/direccion';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-gestion-direccion',
  templateUrl: './gestion-direccion.component.html',
  styleUrls: ['./gestion-direccion.component.css']
})
export class GestionDireccionComponent implements OnInit {
  @Input() user: string;

  direcciones: Direccion[] = [];
  constructor(private direccionService: DireccionService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.cargarDireccion();
  }

  cargarDireccion(): void {
    this.direccionService.lista().subscribe(data => {
    this.direcciones = data;
    //this.dataSource = new MatTableDataSource<Producto>(data);
     //this.dataSource.paginator = this.paginator;

    },
      (err: any) => {
        console.log(err);
      }
    );
  }

  onDelete(id: number): void {
    if (confirm('¿Estás seguro?')) {
      this.direccionService.borrar(id).subscribe(data => {
        this.cargarDireccion();
      });
    }
  }
}
