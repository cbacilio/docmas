import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { interceptorProvider } from './interceptors/producto-interceptor.service';

// módulos para el cliente http y los formularios

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ListaProductoComponent } from './producto/lista-producto.component';
import { HomeComponent } from './home/home.component';
import { DetalleProductoComponent } from './producto/detalle-producto.component';
import { NuevoProductoComponent } from './producto/nuevo-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';
import { LoginComponent } from './auth/login.component';
import { UserComponent } from './users/user/user.component';
import { AdminComponent } from './users/admin/admin.component';
import { RegistroComponent } from './registro/registro.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaProductoComponent,
    HomeComponent,
    DetalleProductoComponent,
    NuevoProductoComponent,
    EditarProductoComponent,
    LoginComponent,
    UserComponent,
    AdminComponent,
    RegistroComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }