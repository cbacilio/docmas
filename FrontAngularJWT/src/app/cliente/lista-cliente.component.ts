import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { ClienteService } from '../services/cliente.service';
import { Cliente } from '../models/cliente';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrls: ['./lista-cliente.component.css']
})
export class ListaClienteComponent implements OnInit {

  @Input() user: string;

  clientes: Cliente[] = [];
  //datos: Producto[] = [];
  //dataSource = null;
  //columnas: string[] = ['id', 'nombreProducto', 'precio'];

  constructor(private clienteService: ClienteService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.cargarClientes();
  }

  cargarClientes(): void {
    this.clienteService.lista().subscribe(data => {
    this.clientes = data;
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
      this.clienteService.borrar(id).subscribe(data => {
        this.cargarClientes();
      });
    }
  }
}