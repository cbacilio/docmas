import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {VentaService} from '../services/venta.service';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Cliente} from '../models/cliente';
import {BehaviorSubject, fromEvent, merge, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {DataSource} from '@angular/cdk/collections';


@Component({
  selector: 'app-venta',
  templateUrl: './venta.component.html',
  styleUrls: ['./venta.component.css']
})
export class VentaComponent implements OnInit {
  datosCliente: Cliente[] = [];
  exampleDatabase: VentaService | null;

  constructor(public httpClient: HttpClient,
    public dialog: MatDialog,
    public ventaService: VentaService) {}
  
  ngOnInit() {
    this.loadData();
  }

  

  public loadData() {
    this.exampleDatabase = new VentaService(this.httpClient);

    this.ventaService.getClientes();
    console.log(this.datosCliente);
  }
  
}




/*
  selectedValue: string;
  selectedCar: string;

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ];

  cars: Car[] = [
    {value: 'volvo', viewValue: 'Volvo'},
    {value: 'saab', viewValue: 'Saab'},
    {value: 'mercedes', viewValue: 'Mercedes'}
  ];*/

