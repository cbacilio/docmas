import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contacto } from '../models/contacto';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

  contactoURL = 'http://localhost:8080/contacto/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Contacto[]> {
    return this.httpClient.get<Contacto[]>(this.contactoURL+ `listarContacto/`, cabecera);
  }

  public detalle(id: number): Observable<Contacto> {
    return this.httpClient.get<Contacto>(this.contactoURL + `detalle/${id}`, cabecera);
  }

  public crear(contacto: Contacto): Observable<any> {
    return this.httpClient.post<any>(this.contactoURL + 'addContacto',contacto, cabecera);
  }

  public editar(contacto: Contacto, id: number): Observable<any> {
    return this.httpClient.put<any>(this.contactoURL + `updatContacto/${id}`, contacto, cabecera);
  }

  public borrar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.contactoURL + `deleteContacto/${id}`, cabecera);
  }
}