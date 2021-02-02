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
import {VentaService} from './services/venta.service';
import {AgregarClienteComponent} from './acciones/agregar/agregar.cliente.component';
import {EditarClienteComponent} from './acciones/editar/editar.cliente.component';
import {BorrarClienteComponent} from './acciones/borrar/borrar.cliente.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TopNavBarComponent } from './top-nav-bar/top-nav-bar.component';
import { ClienteComponent } from './cliente/cliente.component';
import { NuevoComponent } from './nuevo/nuevo.component';
import { AbonoComponent } from './abono/abono.component';
import { ReporteComponent } from './reporte/reporte.component';
import { RouterModule } from '@angular/router';
import { appRoutes } from './app.routing';
import { VentaComponent } from './venta/venta.component';
import { MatSelectModule } from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';


@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    AgregarClienteComponent,
    EditarClienteComponent,
    BorrarClienteComponent,
    TopNavBarComponent,
    NuevoComponent,
    AbonoComponent,
    ReporteComponent,
    VentaComponent
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
    MatSelectModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    RouterModule.forRoot(appRoutes)
  ],
  entryComponents: [
    ClienteComponent,
    VentaComponent,
    AgregarClienteComponent,
    EditarClienteComponent,
    BorrarClienteComponent
  ],
  providers: [
    DataService,VentaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
