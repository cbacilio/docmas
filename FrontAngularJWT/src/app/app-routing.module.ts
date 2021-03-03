import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
//import { ListaClienteComponent } from './cliente/lista-cliente.component';
import { DetalleClienteComponent } from './cliente/detalle-cliente.component';
import { NuevoClienteComponent } from './cliente/nuevo-cliente.component';
import { EditarClienteComponent } from './cliente/editar-cliente.component';
import { LoginComponent } from './auth/login.component';
import { AdminComponent } from './users/admin/admin.component';
import { UserComponent } from './users/user/user.component';
import { RegistroComponent } from './registro/registro.component';
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


import { GuardService as guard } from './guards/guard.service';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  //{path: 'lista', component: ListaClienteComponent},

  // clientes: utilizamos canActivate
  {
    path: 'detalle/:id', component: DetalleClienteComponent,
    canActivate: [guard], data: { expectedRol: ['admin', 'user'] }
  },
  {
    path: 'nuevo', component: NuevoClienteComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },
  {
    path: 'editar/:id', component: EditarClienteComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },


  // Producto

  {
    path: 'detalleProducto/:id', component: DetalleGestionProductoComponent,
    canActivate: [guard], data: { expectedRol: ['admin', 'user'] }
  },
  {
    path: 'nuevoProducto', component: NuevoGestionProductoComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },
  {
    path: 'editarProducto/:id', component: EditarGestionProductoComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },

  // Contacto

  {
    path: 'detalleContacto/:id', component: DetalleGestionContactoComponent,
    canActivate: [guard], data: { expectedRol: ['admin', 'user'] }
  },
  {
    path: 'nuevoContacto', component: NuevoGestionContactoComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },
  {
    path: 'editarContacto/:id', component: EditarGestionContactoComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },

  // Direccion

  {
    path: 'detalleDireccion/:id', component: DetalleGestionDireccionComponent,
    canActivate: [guard], data: { expectedRol: ['admin', 'user'] }
  },
  {
    path: 'nuevoDireccion', component: NuevoGestionDireccionComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },
  {
    path: 'editarDireccion/:id', component: EditarGestionDireccionComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },

  // Venta

  {
    path: 'detalleVenta/:id', component: DetalleAgregarVentaComponent,
    canActivate: [guard], data: { expectedRol: ['admin', 'user'] }
  },
  {
    path: 'nuevoAgregarVenta', component: NuevoAgregarVentaComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },
  {
    path: 'editarVenta/:id', component: EditarAgregarVentaComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },

   // Abono

   {
    path: 'detalleAgregarAbono/:id', component: DetalleAgregarAbonoComponent,
    canActivate: [guard], data: { expectedRol: ['admin', 'user'] }
  },
  {
    path: 'nuevoAgregarAbono', component: NuevoAgregarAbonoComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },
  {
    path: 'editarAgregarAbono/:id', component: EditarAgregarAbonoComponent,
    canActivate: [guard], data: { expectedRol: ['admin'] }
  },


  // user y admin

  { path: 'gestionCliente', component: AdminComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },
  { path: 'cuentasxcliente', component: CuentasPorClienteComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },

  { path: 'addVenta', component: AgregarVentaComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },
  { path: 'addAbono', component: AgregarAbonoComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },

  { path: 'gestionContacto', component: GestionContactoComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },
  { path: 'gestionDireccion', component: GestionDireccionComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },
  { path: 'gestionProducto', component: GestionProductoComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },


  { path: 'user', component: UserComponent, canActivate: [guard], data: { expectedRol: ['user'] } },

  // rutas a login y registro
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: '**', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }