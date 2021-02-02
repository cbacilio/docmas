
import {Routes} from "@angular/router"
import {ClienteComponent} from "./cliente/cliente.component"
import {NuevoComponent} from "./nuevo/nuevo.component"
import {AbonoComponent} from "./abono/abono.component"
import {ReporteComponent} from "./reporte/reporte.component"
import {VentaComponent} from "./venta/venta.component"


export const  appRoutes: Routes = [
    { path: 'cliente', component: ClienteComponent },
    { path: 'venta', component: VentaComponent },
    { path: 'nuevo', component: NuevoComponent },
    { path: 'abono', component: AbonoComponent },
    { path: 'reporte', component: ReporteComponent },
  ];