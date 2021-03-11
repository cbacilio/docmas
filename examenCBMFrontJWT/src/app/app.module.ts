import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { interceptorProvider } from './interceptors/producto-interceptor.service';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// módulos para el cliente http y los formularios

import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ListaClienteComponent } from './cliente/lista-cliente.component';
import { HomeComponent } from './home/home.component';
import { DetalleClienteComponent } from './cliente/detalle-cliente.component';
import { NuevoClienteComponent } from './cliente/nuevo-cliente.component';
import { EditarClienteComponent } from './cliente/editar-cliente.component';
import { LoginComponent } from './auth/login.component';
import { UserComponent } from './users/user/user.component';
import { AdminComponent } from './users/admin/admin.component';
import { RegistroComponent } from './registro/registro.component';
import {MatTableModule} from '@angular/material/table';
import { CuentasPorClienteComponent } from './cuentas-por-cliente/cuentas-por-cliente.component';
import { AgregarVentaComponent } from './agregar-venta/agregar-venta.component';
import { AgregarAbonoComponent } from './agregar-abono/agregar-abono.component';
import { GestionContactoComponent } from './gestion-contacto/gestion-contacto.component';
import { GestionDireccionComponent } from './gestion-direccion/gestion-direccion.component';
import { GestionProductoComponent } from './gestion-producto/gestion-producto.component';
import { DetalleGestionProductoComponent } from './gestion-producto/detalle-gestion-producto/detalle-gestion-producto.component';
import { NuevoGestionProductoComponent } from './gestion-producto/nuevo-gestion-producto/nuevo-gestion-producto.component';
import { EditarGestionProductoComponent } from './gestion-producto/editar-gestion-producto/editar-gestion-producto.component';
import { DetalleGestionDireccionComponent } from './gestion-direccion/detalle-gestion-direccion/detalle-gestion-direccion.component';
import { EditarGestionDireccionComponent } from './gestion-direccion/editar-gestion-direccion/editar-gestion-direccion.component';
import { NuevoGestionDireccionComponent } from './gestion-direccion/nuevo-gestion-direccion/nuevo-gestion-direccion.component';
import { DetalleGestionContactoComponent } from './gestion-contacto/detalle-gestion-contacto/detalle-gestion-contacto.component';
import { EditarGestionContactoComponent } from './gestion-contacto/editar-gestion-contacto/editar-gestion-contacto.component';
import { NuevoGestionContactoComponent } from './gestion-contacto/nuevo-gestion-contacto/nuevo-gestion-contacto.component';
import { DetalleAgregarVentaComponent } from './agregar-venta/detalle-agregar-venta/detalle-agregar-venta.component';
import { EditarAgregarVentaComponent } from './agregar-venta/editar-agregar-venta/editar-agregar-venta.component';
import { NuevoAgregarVentaComponent } from './agregar-venta/nuevo-agregar-venta/nuevo-agregar-venta.component';
import { DetalleAgregarAbonoComponent } from './agregar-abono/detalle-agregar-abono/detalle-agregar-abono.component';
import { EditarAgregarAbonoComponent } from './agregar-abono/editar-agregar-abono/editar-agregar-abono.component';
import { NuevoAgregarAbonoComponent } from './agregar-abono/nuevo-agregar-abono/nuevo-agregar-abono.component'; 

import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatToolbarModule } from '@angular/material/toolbar';


@NgModule({
  declarations: [
    AppComponent,
    ListaClienteComponent,
    HomeComponent,
    DetalleClienteComponent,
    NuevoClienteComponent,
    EditarClienteComponent,
    LoginComponent,
    UserComponent,
    AdminComponent,
    RegistroComponent,
    CuentasPorClienteComponent,
    AgregarVentaComponent,
    AgregarAbonoComponent,
    GestionContactoComponent,
    GestionDireccionComponent,
    GestionProductoComponent,
    DetalleGestionProductoComponent,
    NuevoGestionProductoComponent,
    EditarGestionProductoComponent,
    DetalleGestionDireccionComponent,
    EditarGestionDireccionComponent,
    NuevoGestionDireccionComponent,
    DetalleGestionContactoComponent,
    EditarGestionContactoComponent,
    NuevoGestionContactoComponent,
    DetalleAgregarVentaComponent,
    EditarAgregarVentaComponent,
    NuevoAgregarVentaComponent,
    DetalleAgregarAbonoComponent,
    EditarAgregarAbonoComponent,
    NuevoAgregarAbonoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    MatTableModule,
    MatSelectModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatToolbarModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }