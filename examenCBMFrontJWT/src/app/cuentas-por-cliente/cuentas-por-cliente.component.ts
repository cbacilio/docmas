import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { Cliente } from '../models/cliente';
import { CuentaXClienteService } from '../services/cuentaxcliente.service';

@Component({
  selector: 'app-cuentas-por-cliente',
  templateUrl: './cuentas-por-cliente.component.html',
  styleUrls: ['./cuentas-por-cliente.component.css']
})
export class CuentasPorClienteComponent implements OnInit {
  @Input() user: string;

  constructor(private cuentaXClienteService: CuentaXClienteService) { }
  cuentas: Cliente[] = [];

  ngOnInit() {
    this.cargarClientes();
  }

  cargarClientes(): void {
    this.cuentaXClienteService.listaCuentaXCliente().subscribe(data => {
    this.cuentas = data;
    //this.dataSource = new MatTableDataSource<Producto>(data);
     //this.dataSource.paginator = this.paginator;

    },
      (err: any) => {
        console.log(err);
      }
    );
  }

 /* onDelete(id: number): void {
    if (confirm('¿Estás seguro?')) {
      this.clienteService.borrar(id).subscribe(data => {
        this.cargarClientes();
      });
    }
  }*/
}