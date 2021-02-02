import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cliente } from '../models/cliente';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable()
export class VentaService {    

    private API_URL_CLIENTE = 'http://localhost:8080/joyeria/listarCliente';
    private API_URL_ADD_CLIENTE = 'http://localhost:8080/joyeria/addCliente';
    private API_URL_DELETE_CLIENTE = 'http://localhost:8080/joyeria/deleteCliente/';
    private API_URL_UPDATE_CLIENTE = 'http://localhost:8080/joyeria/updateCliente/';

    dataChange: BehaviorSubject<Cliente[]> = new BehaviorSubject<Cliente[]>([]);

    dialogData: any;
    datosCliente: Cliente[] = [];

    constructor(private httpClient: HttpClient) { }


    get data(): Cliente[] {
        return this.dataChange.value;
    }

    getDialogData() {
        return this.dialogData;
    }

   
    getClientes(): void {
        this.httpClient.get<Cliente[]>(this.API_URL_CLIENTE).subscribe(data => {
            console.log(data)
            this.dataChange.next(data);
        },
            (error: HttpErrorResponse) => {
            });


           
    }


}