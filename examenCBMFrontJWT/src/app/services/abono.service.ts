import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Abono } from '../models/abono';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class AbonoService {

  abonoURL = 'http://localhost:8080/abono/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Abono[]> {
    return this.httpClient.get<Abono[]>(this.abonoURL+ `listarAbono/`, cabecera);
  }

  public detalle(id: number): Observable<Abono> {
    return this.httpClient.get<Abono>(this.abonoURL + `detalle/${id}`, cabecera);
  }

  public crear(Abono: Abono): Observable<any> {
    return this.httpClient.post<any>(this.abonoURL + 'addAbono',Abono, cabecera);
  }

  public editar(Abono: Abono, id: number): Observable<any> {
    return this.httpClient.put<any>(this.abonoURL + `updatAbono/${id}`, Abono, cabecera);
  }

  public borrar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.abonoURL + `deleteAbono/${id}`, cabecera);
  }
}