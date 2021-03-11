import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Venta } from '../models/venta';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class VentaService {

  ventaURL = 'http://localhost:8080/venta/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Venta[]> {
    return this.httpClient.get<Venta[]>(this.ventaURL+ `listarVenta/`, cabecera);
  }

  public detalle(id: number): Observable<Venta> {
    return this.httpClient.get<Venta>(this.ventaURL + `detalle/${id}`, cabecera);
  }

  public crear(venta: Venta): Observable<any> {
    console.log(venta)
    return this.httpClient.post<any>(this.ventaURL + 'addVenta',venta, cabecera);
  }

  public editar(venta: Venta, id: number): Observable<any> {
    return this.httpClient.put<any>(this.ventaURL + `updatVenta/${id}`, venta, cabecera);
  }

  public borrar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.ventaURL + `deleteVenta/${id}`, cabecera);
  }
}