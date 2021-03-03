import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';

const cabecera = { headers: new HttpHeaders({ 'Content-TYpe': 'application/json' }) };

@Injectable({
    providedIn: 'root'
})
export class CuentaXClienteService {

    clienteURL = 'http://localhost:8080/cliente/';

    constructor(private httpClient: HttpClient) { }



    public listaCuentaXCliente(): Observable<Cliente[]> {
        return this.httpClient.get<Cliente[]>(this.clienteURL + `listarCliente/`, cabecera);
    }

}