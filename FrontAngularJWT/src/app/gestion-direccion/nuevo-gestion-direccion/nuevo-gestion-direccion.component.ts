import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { Direccion } from '../../models/direccion';
import { DireccionService } from '../../services/direccion.service';

@Component({
  selector: 'app-nuevo-gestion-direccion',
  templateUrl: './nuevo-gestion-direccion.component.html',
  styleUrls: ['./nuevo-gestion-direccion.component.css']
})
export class NuevoGestionDireccionComponent implements OnInit {
    form: any = {};
    direccion: Direccion;
    creado = false;
    failDireccion = false;
    mensajeFail = '';
    mensajeOK = '';
  
    constructor(private direccionService: DireccionService) { }
  
    ngOnInit() {
    }
  
    onCreate(): void {
      this.direccionService.crear(this.form).subscribe(data => {
        this.mensajeOK = data.mensaje;
        this.creado = true;
        this.failDireccion = false;
      },
        (err: any) => {
          this.mensajeFail = err.error.mensaje;
          this.creado = false;
          this.failDireccion = true;
        }
      );
    }
  
    volver(): void {
      window.history.back();
    }
  
  }