import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { Contacto } from '../../models/contacto';
import { ContactoService } from '../../services/contacto.service';

@Component({
  selector: 'app-nuevo-gestion-contacto',
  templateUrl: './nuevo-gestion-contacto.component.html',
  styleUrls: ['./nuevo-gestion-contacto.component.css']
})
export class NuevoGestionContactoComponent implements OnInit {
    form: any = {};
    contacto: Contacto;
    creado = false;
    failContacto = false;
    mensajeFail = '';
    mensajeOK = '';
  
    constructor(private contactoService: ContactoService) { }
  
    ngOnInit() {
    }
  
    onCreate(): void {
      this.contactoService.crear(this.form).subscribe(data => {
        this.mensajeOK = data.mensaje;
        this.creado = true;
        this.failContacto = false;
      },
        (err: any) => {
          this.mensajeFail = err.error.mensaje;
          this.creado = false;
          this.failContacto = true;
        }
      );
    }
  
    volver(): void {
      window.history.back();
    }
  
  }