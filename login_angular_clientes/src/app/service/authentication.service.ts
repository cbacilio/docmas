import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Login} from '../models/Login';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private  url_login = 'http://localhost:8080/login';

  constructor (private httpClient: HttpClient) {}

  Login: [{
    username: String;
    password: String;
}];

  /*getClientes(): void {
    this.httpClient.get<Login[]>(this.url_login).subscribe(data => {
      console.log(data)
      },
      (error: HttpErrorResponse) => {
      });
  }*/

  authenticate(username, password) {
    console.log("Ingresa autenticar")
    this.httpClient.get<Login[]>(this.url_login).subscribe(data => {
      console.log(data)
      },
      (error: HttpErrorResponse) => {
      });
   
    /*if (username === "admin" && password === "admin") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }*/
    return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}