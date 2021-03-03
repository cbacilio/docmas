import { Component, OnInit } from '@angular/core';
import { ContactoService } from '../../services/contacto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-gestion-contacto',
  templateUrl: './editar-gestion-contacto.component.html',
  styleUrls: ['./editar-gestion-contacto.component.css']
})
export class EditarGestionContactoComponent implements OnInit {
  form: any = {};
  actualizado = false;
  failActualizado = false;
  msjErr = '';
  msjOK = '';

  failInit = false;

  constructor(private contactoService: ContactoService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.contactoService.detalle(id).subscribe( data => {
      this.form.email = data.email;
      this.form.telefono = data.telefono;
    },
      (err: any) => {
        this.failInit = true;
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.contactoService.editar(this.form, id).subscribe( data => {
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