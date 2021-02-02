import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    console.log("ingresa login")
    if (this.loginservice.authenticate(this.username, this.password)
    ) { 
      this.invalidLogin = false
      this.router.navigate(['listar' ])
     
    } else
      this.invalidLogin = true
  }

}