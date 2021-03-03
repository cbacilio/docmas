import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../services/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css']
})
export class EditarClienteComponent implements OnInit {
  form: any = {};
  actualizado = false;
  failActualizado = false;
  msjErr = '';
  msjOK = '';

  failInit = false;

  constructor(private clienteService: ClienteService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.clienteService.detalle(id).subscribe( data => {
      this.form.idCliente = data.idCliente;
      this.form.nombre = data.nombre;
      this.form.apellidoPaterno = data.apellidoPaterno;
      this.form.apellidoMaterno = data.apellidoMaterno;
      this.form.edad = data.edad;
      this.form.sexo = data.sexo;
      this.form.rfc = data.rfc;
      //this.form.descripcion = data.descripcion;
    },
      (err: any) => {
        this.failInit = true;
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.clienteService.editar(this.form, id).subscribe( data => {
      this.actualizado = true;
      this.failActualizado = false;
      this.msjOK = data.mensaje;
    },
    (err: any) => {
      this.actualizado = false;
      this.failActualizado = true;
      this.msjErr = err.error.mensaje;
    }
    );
  }

  volver(): void {
    window.history.back();
  }

}