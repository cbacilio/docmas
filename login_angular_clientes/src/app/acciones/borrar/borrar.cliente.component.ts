import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import {Component, Inject} from '@angular/core';
import {DataService} from '../../services/data.service';


@Component({
  selector: 'app-delete.dialog',
  templateUrl: '../../acciones/borrar/borrar.cliente.html',
  styleUrls: ['../../acciones/borrar/borrar.cliente.css']
})
export class BorrarClienteComponent {

  constructor(public dialogRef: MatDialogRef<BorrarClienteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: DataService) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmDelete(): void {
    //this.dataService.deleteCliente(this.data.id);
  }
}
