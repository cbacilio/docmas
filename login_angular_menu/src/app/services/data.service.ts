import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Cliente} from '../models/cliente';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';

@Injectable()
export class DataService {
  private  API_URL = 'http://localhost:8080/employees/listar';
  //private  API_URL_ADD = 'http://localhost:8080/cliente/add';
  //private  API_URL_DELETE = 'http://localhost:8080/cliente/delete/';
  //private  API_URL_UPDATE = 'http://localhost:8080/cliente/update/';


  dataChange: BehaviorSubject<Cliente[]> = new BehaviorSubject<Cliente[]>([]);

  dialogData: any;

  constructor (private httpClient: HttpClient) {
    console.log("LEGA CONSTRUCTOR");
    //this.getClientes();
  }

  get data(): Cliente[] {
    return this.dataChange.value;
  }

  getDialogData() {
    return this.dialogData;
  }

  getClientes(): void {
    console.log("Ingresa a los clientes");
    this.httpClient.get<Cliente[]>(this.API_URL).subscribe(data => {
      console.log(data);
        this.dataChange.next(data);
      },
      (error: HttpErrorResponse) => {
      });
  }


    /*addCliente(cliente: Cliente): void {
      this.httpClient.post(this.API_URL_ADD, cliente).subscribe(data => {
        this.dialogData = cliente;
        },
        (err: HttpErrorResponse) => {
      });
     }


    updateCliente(cliente: Cliente): void {
      this.httpClient.put(this.API_URL_UPDATE + cliente.id, cliente).subscribe(data => {
        this.dialogData = cliente;
        },
        (err: HttpErrorResponse) => {
      });
     }

  deleteCliente(id: number): void {
    this.httpClient.delete(this.API_URL_DELETE + id).subscribe(data => {
      },
      (err: HttpErrorResponse) => {
      }
    );
  }*/


}


