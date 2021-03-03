import { Component, OnInit } from '@angular/core';
import { Cliente } from '../models/cliente';
import { ClienteService } from '../services/cliente.service';

@Component({
  selector: 'app-nuevo-cliente',
  templateUrl: './nuevo-cliente.component.html',
  styleUrls: ['./nuevo-cliente.component.css']
})
export class NuevoClienteComponent implements OnInit {
  form: any = {};
  cliente: Cliente;
  creado = false;
  failCliente = false;
  mensajeFail = '';
  mensajeOK = '';

  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
  }

  onCreate(): void {
    this.clienteService.crear(this.form).subscribe(data => {
      this.mensajeOK = data.mensaje;
      this.creado = true;
      this.failCliente = false;
    },
      (err: any) => {
        this.mensajeFail = err.error.mensaje;
        this.creado = false;
        this.failCliente = true;
      }
    );
  }

  volver(): void {
    window.history.back();
  }

}