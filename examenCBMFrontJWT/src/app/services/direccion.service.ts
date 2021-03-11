import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Direccion } from '../models/direccion';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class DireccionService {

  direccionURL = 'http://localhost:8080/direccion/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Direccion[]> {
    return this.httpClient.get<Direccion[]>(this.direccionURL+ `listarDireccion/`, cabecera);
  }

  public detalle(id: number): Observable<Direccion> {
    return this.httpClient.get<Direccion>(this.direccionURL + `detalle/${id}`, cabecera);
  }

  public crear(direccion: Direccion): Observable<any> {
    return this.httpClient.post<any>(this.direccionURL + 'addDireccion',direccion, cabecera);
  }

  public editar(direccion: Direccion, id: number): Observable<any> {
    return this.httpClient.put<any>(this.direccionURL + `updatDireccion/${id}`, direccion, cabecera);
  }

  public borrar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.direccionURL + `deleteDireccion/${id}`, cabecera);
  }
}