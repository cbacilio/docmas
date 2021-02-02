import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import {DataService} from './services/data.service';
import {AgregarClienteComponent} from './acciones/agregar/agregar.cliente.component';
import {EditarClienteComponent} from './acciones/editar/editar.cliente.component';
import {BorrarClienteComponent} from './acciones/borrar/borrar.cliente.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TopNavBarComponent } from './top-nav-bar/top-nav-bar.component';
import {RouterModule} from '@angular/router';
import { appRoutes } from './app.routing';
import { ListarComponent } from './listar/listar.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';


@NgModule({
  declarations: [
    AppComponent,
    AgregarClienteComponent,
    EditarClienteComponent,
    BorrarClienteComponent,
    TopNavBarComponent,
    ListarComponent, LoginComponent, LogoutComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatDialogModule,
    FormsModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatSortModule,
    MatTableModule,
    MatToolbarModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  entryComponents: [
    AgregarClienteComponent,
    EditarClienteComponent,
    BorrarClienteComponent
  ],
  providers: [
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
