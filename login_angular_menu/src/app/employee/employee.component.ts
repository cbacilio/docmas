import { Component, OnInit } from '@angular/core';
import { Cliente } from '../models/Cliente';
import { HttpClientService, Employee } from '../service/httpclient.service';
import { Observable } from "rxjs";
@Component({
  selector: 'app-root',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  //clientes: Observable<Cliente[]>;
  //clientes:Cliente[];

 /* constructor(
    private httpClientService:HttpClientService
  ) { }*/


  clientes = null;
  
  constructor(private httpClientService:HttpClientService) {
  }
  
  ngOnInit() {
    this.clientes=this.httpClientService.retornar();
  }


 /*ngOnInit() {
    this.reloadData();
  }*/

  reloadData() {
      return this.httpClientService.getEmployees().subscribe(response => this.handleSuccessfulResponse(response));
  }

  /*reloadData() {
    console.log("RELOAD");
    this.clientes = this.httpClientService.getEmployees();
    console.log(this.clientes);
  }*/

handleSuccessfulResponse(response)
{
  console.log("handleSuccessfulResponse",response)
  console.log("Resultados finales",this.clientes)
    return this.clientes=response;

}

/*deleteEmployee(cliente: Employee): void {
   this.httpClientService.deleteEmployee(cliente)
     .subscribe( data => {
      this.clientes = this.clientes.filter(u => u !== clientes);
   })
};*/


}