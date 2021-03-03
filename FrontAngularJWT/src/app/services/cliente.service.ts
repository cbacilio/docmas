import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  clienteURL = 'http://localhost:8080/cliente/';

  constructor(private httpClient: HttpClient) { }

  /*public lista(): Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(this.productoURL + 'lista', cabecera);
  }*/

  public lista(): Observable<Cliente[]> {
    return this.httpClient.get<Cliente[]>(this.clienteURL+ `listarCliente/`, cabecera);
  }

  public detalle(id: number): Observable<Cliente> {
    return this.httpClient.get<Cliente>(this.clienteURL + `detalle/${id}`, cabecera);
  }

  public crear(cliente: Cliente): Observable<any> {
    return this.httpClient.post<any>(this.clienteURL + 'addCliente', cliente, cabecera);
  }

  public editar(cliente: Cliente, id: number): Observable<any> {
    return this.httpClient.put<any>(this.clienteURL + `updateCliente/${id}`, cliente, cabecera);
  }

  public borrar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.clienteURL + `deleteCliente/${id}`, cabecera);
  }
}