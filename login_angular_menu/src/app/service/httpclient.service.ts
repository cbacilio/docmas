import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Cliente} from '../models/cliente';
import { Observable } from "rxjs";

export class Employee{

  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {




  constructor(
    private http:HttpClient
  ) { 
     }

    retornar() {
    return [
              {
                codigo: 1,
                descripcion: "papas",
                precio: 12.33
              },
              {
                codigo: 2,
                descripcion: "manzanas",
                precio: 54
              },
              {
                codigo: 3,
                descripcion: "sandía",
                precio: 14
              }
           ];
  }   

/*getEmployees()
  {
    console.log("Inicia la carga de clientes")
    let basicString=this.getHeaders();

    let headers=new HttpHeaders(
      {Authorization:basicString}
    );
    console.log("Inicia la carga de los clientes");
    return this.httpClient.get<Employee[]>('http://localhost:8080/employees',{headers});
  }*/

  getEmployees() {
    let  API_URL = 'http://localhost:8080/employees/listar';
    console.log("Inicia la carga de clientes")
    let basicString=this.getHeaders();

    let headers=new HttpHeaders(
      {Authorization:basicString}
    );
    console.log("Inicia la carga de los clientes");
    return this.http.get<Cliente[]>(API_URL,{headers});
    }



  /*getEmployees(): Observable<any> {
    let  API_URL = 'http://localhost:8080/employees/listar';
    console.log("Inicia la carga de clientes")
    let basicString=this.getHeaders();

    let headers=new HttpHeaders(
      {Authorization:basicString}
    );
    return this.http.get<Cliente[]>(API_URL,{headers});
    //return this.http.get(`${this.API_URL}/${id}`);
  }*/

  public deleteEmployee(employee) {
    return this.http.delete<Employee>("http://localhost:8080/employees" + "/"+ employee.empId);
  }

  public createEmployee(employee) {
    return this.http.post<Employee>("http://localhost:8080/employees", employee);
  }



getHeaders(){
  let username='admin'
  let password='password'

  let  basicString='Basic '+window.btoa(username + ':' + password)
  return basicString;
}

}