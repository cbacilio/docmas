import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import {Component, Inject} from '@angular/core';
import {DataService} from '../../services/data.service';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-baza.dialog',
  templateUrl: '../../acciones/editar/editar.cliente.html',
  styleUrls: ['../../acciones/editar/editar.cliente.css']
})
export class EditarClienteComponent {

  constructor(public dialogRef: MatDialogRef<EditarClienteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: DataService) { }

  formControl = new FormControl('', [
    Validators.required
    // Validators.email,
  ]);

  getErrorMessage() {
    return this.formControl.hasError('required') ? 'Campo requerido' :
      this.formControl.hasError('email') ? 'Nombre no válido' :
        '';
  }

  submit() {
    // emppty stuff
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  updateCliente(): void {
    console.log(this.data)
    this.dataService.updateCliente(this.data);
    this.dataService.getClientes();
  }
}
