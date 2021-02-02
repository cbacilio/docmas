import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Cliente} from '../models/cliente';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';

@Injectable()
export class DataService {

  // OPERACIONES CLIENTES

  private  API_URL_CLIENTE = 'http://localhost:8080/joyeria/listarCliente';
  private  API_URL_ADD_CLIENTE = 'http://localhost:8080/joyeria/addCliente';
  private  API_URL_DELETE_CLIENTE = 'http://localhost:8080/joyeria/deleteCliente/';
  private  API_URL_UPDATE_CLIENTE = 'http://localhost:8080/joyeria/updateCliente/';


  dataChange: BehaviorSubject<Cliente[]> = new BehaviorSubject<Cliente[]>([]);

  dialogData: any;

  constructor (private httpClient: HttpClient) {}

  get data(): Cliente[] {
    return this.dataChange.value;
  }

  getDialogData() {
    return this.dialogData;
  }

  getClientes(): void {
    this.httpClient.get<Cliente[]>(this.API_URL_CLIENTE).subscribe(data => {
        this.dataChange.next(data);
      },
      (error: HttpErrorResponse) => {
      });
  }


    addCliente(cliente: Cliente): void {
      this.httpClient.post(this.API_URL_ADD_CLIENTE, cliente).subscribe(data => {
        this.dialogData = cliente;
        },
        (err: HttpErrorResponse) => {
      });
     }


    updateCliente(cliente: Cliente): void {
      console.log(cliente)
      this.httpClient.put(this.API_URL_UPDATE_CLIENTE + cliente.idCliente, cliente).subscribe(data => {
        this.dialogData = cliente;
        },
        (err: HttpErrorResponse) => {
      });
     }

  deleteCliente(id: number): void {
    this.httpClient.delete(this.API_URL_DELETE_CLIENTE + id).subscribe(data => {
      },
      (err: HttpErrorResponse) => {
      }
    );
  }


}


