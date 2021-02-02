import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import {Component, Inject} from '@angular/core';
import {DataService} from '../../services/data.service';
import {FormControl, Validators} from '@angular/forms';
import {Cliente} from '../../models/cliente';

@Component({
  selector: 'app-add.dialog',
  templateUrl: '../../acciones/agregar/agregar.cliente.html',
  styleUrls: ['../../acciones/agregar/agregar.cliente.css']
})

export class AgregarClienteComponent {
  constructor(public dialogRef: MatDialogRef<AgregarClienteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Cliente,
              public dataService: DataService) { }

  formControl = new FormControl('', [
    Validators.required
  ]);

  getErrorMessage() {
    return this.formControl.hasError('required') ? 'Campo requerido' :
      this.formControl.hasError('nombre') ? 'Nombre no válido' :
        '';
  }

  submit() {
  // emppty stuff
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  public confirmAdd(): void {
   // this.dataService.addCliente(this.data);
  }

}
