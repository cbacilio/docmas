import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { ProductoService } from '../services/producto.service';
import { Producto } from '../models/producto';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-gestion-producto',
  templateUrl: './gestion-producto.component.html',
  styleUrls: ['./gestion-producto.component.css']
})
export class GestionProductoComponent implements OnInit {
  @Input() user: string;
  documentoCreado = false;
  mensajeOK = '';
  productos: Producto[] = [];
  constructor(private productoService: ProductoService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.documentoCreado = false;
    this.cargarProductos();
  }

  cargarProductos(): void {
    this.productoService.lista().subscribe(data => {
    this.productos = data;
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
      this.productoService.borrar(id).subscribe(data => {
        this.cargarProductos();
      });
    }
  }

	generaPDF(): void {
    this.productoService.getProfilesPDF()
      .subscribe(data => {
        //this.downloadFile(data, "Lista_Perfiles.pdf", "application/pdf");
       
      });

      this.mensajeOK = "Reporte creado";
      this.documentoCreado = true;
  }


  downloadFile(data: any, filename: string, fileType: string) {

 

    // It is necessary to create a new blob object with mime-type explicitly set

    // otherwise only Chrome works like it should

    var newBlob = new Blob([data], { type: fileType });

 

    // IE doesn't allow using a blob object directly as link href

    // instead it is necessary to use msSaveOrOpenBlob

    if (window.navigator && window.navigator.msSaveOrOpenBlob) {

      window.navigator.msSaveOrOpenBlob(newBlob);

      return;

    }

 

    // For other browsers: 

    // Create a link pointing to the ObjectURL containing the blob.

    const dataFile = window.URL.createObjectURL(newBlob);

 

    var link = document.createElement('a');

    link.href = dataFile;

    link.download = filename;

    // this is necessary as link.click() does not work on the latest firefox

    link.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true, view: window }));

 

    setTimeout(function () {

      // For Firefox it is necessary to delay revoking the ObjectURL

      window.URL.revokeObjectURL(dataFile);

      link.remove();

    }, 100);

  }


}
