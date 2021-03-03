import { Component, OnInit } from '@angular/core';
import { DireccionService } from '../../services/direccion.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-gestion-direccion',
  templateUrl: './editar-gestion-direccion.component.html',
  styleUrls: ['./editar-gestion-direccion.component.css']
})
export class EditarGestionDireccionComponent implements OnInit {
  form: any = {};
  actualizado = false;
  failActualizado = false;
  msjErr = '';
  msjOK = '';

  failInit = false;

  constructor(private direccionService: DireccionService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.direccionService.detalle(id).subscribe( data => {
      this.form.calle = data.calle;
      this.form.colonia = data.colonia;
      this.form.municipio = data.municipio;
      this.form.estado = data.estado;
      this.form.cp = data.cp;
    },
      (err: any) => {
        this.failInit = true;
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.direccionService.editar(this.form, id).subscribe( data => {
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