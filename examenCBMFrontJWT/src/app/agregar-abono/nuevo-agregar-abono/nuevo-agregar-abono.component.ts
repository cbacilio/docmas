import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { Abono } from '../../models/abono';
import { AbonoService } from '../../services/abono.service';
import { VentaService } from '../../services/venta.service';
import { Venta } from '../../models/Venta';


@Component({
  selector: 'app-nuevo-agregar-abono',
  templateUrl: './nuevo-agregar-abono.component.html',
  styleUrls: ['./nuevo-agregar-abono.component.css']
})
export class NuevoAgregarAbonoComponent implements OnInit {

  
  ventas: Venta[] = [];
  form: any = {};
  abono: Abono;
  creado = false;
  failAbono = false;
  mensajeFail = '';
  mensajeOK = '';

  constructor(private abonoService: AbonoService,private ventaService: VentaService) { }

  ngOnInit() {
    this.cargarVentas();
  }

  cargarVentas(): void {
    this.ventaService.lista().subscribe(data => {
    this.ventas = data;
    },
      (err: any) => {
        console.log(err);
      }
    );
  }

  onCreate(): void {
    this.abonoService.crear(this.form).subscribe(data => {
      this.mensajeOK = data.mensaje;
      this.creado = true;
      this.failAbono = false;
    },
      (err: any) => {
        this.mensajeFail = err.error.mensaje;
        this.creado = false;
        this.failAbono = true;
      }
    );
  }

  volver(): void {
    window.history.back();
  }

}