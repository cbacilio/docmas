import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {DataService} from './services/data.service';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Cliente} from './models/cliente';
import {DataSource} from '@angular/cdk/collections';
import {AgregarClienteComponent} from './acciones/agregar/agregar.cliente.component';
import {EditarClienteComponent} from './acciones/editar/editar.cliente.component';
import {BorrarClienteComponent} from './acciones/borrar/borrar.cliente.component';
import {BehaviorSubject, fromEvent, merge, Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  ngOnInit() {
  }



}
