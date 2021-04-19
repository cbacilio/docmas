import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';

const cabecera = {headers: new HttpHeaders({'Content-TYpe': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  productoURL = 'http://localhost:8080/producto/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(this.productoURL+ `listarProducto/`, cabecera);
  }

  public detalle(id: number): Observable<Producto> {
    return this.httpClient.get<Producto>(this.productoURL + `detalle/${id}`, cabecera);
  }

  public crear(producto: Producto): Observable<any> {
    return this.httpClient.post<any>(this.productoURL + 'addProducto',producto, cabecera);
  }

  public editar(producto: Producto, id: number): Observable<any> {
    return this.httpClient.put<any>(this.productoURL + `updatProducto/${id}`, producto, cabecera);
  }

  public borrar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.productoURL + `deleteProducto/${id}`, cabecera);
  }
  
  getProfilesPDF() {
    return this.httpClient.get(this.productoURL + `report/${'pdf'}`, { responseType: 'blob' });
}

}