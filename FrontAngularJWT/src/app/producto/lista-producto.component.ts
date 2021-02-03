import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { ProductoService } from '../services/producto.service';
import { Producto } from '../models/producto';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-lista-producto',
  templateUrl: './lista-producto.component.html',
  styleUrls: ['./lista-producto.component.css']
})
export class ListaProductoComponent implements OnInit {

  @Input() user: string;

  productos: Producto[] = [];
  //datos: Producto[] = [];
  //dataSource = null;
  //columnas: string[] = ['id', 'nombreProducto', 'precio'];

  constructor(private productoService: ProductoService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
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
}