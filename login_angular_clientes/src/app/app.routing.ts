import {Routes} from "@angular/router"
import {ListarComponent} from "./listar/listar.component"
/*import {NuevoComponent} from "./nuevo/nuevo.component"
import {AbonoComponent} from "./abono/abono.component"
import {ReporteComponent} from "./reporte/reporte.component"
import {VentaComponent} from "./venta/venta.component"*/
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';


export const  appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'listar', component: ListarComponent },
  { path: '**', component: LoginComponent },
  //{ path: 'venta', component: VentaComponent },
  //{ path: 'nuevo', component: NuevoComponent },
  //{ path: 'abono', component: AbonoComponent },
  //{ path: 'reporte', component: ReporteComponent },
];


/*const  routes: Routes= [
  //{ path: '', component: EmployeeComponent,canActivate:[AuthGaurdService] },
  { path: 'listar', component: ListarComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class appRoutes { }*/