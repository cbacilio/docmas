import { Component, OnInit } from '@angular/core';
import { VentaService } from '../../services/venta.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-agregar-venta',
  templateUrl: './editar-agregar-venta.component.html',
  styleUrls: ['./editar-agregar-venta.component.css']
})
export class EditarAgregarVentaComponent implements OnInit {
  form: any = {};
  actualizado = false;
  failActualizado = false;
  msjErr = '';
  msjOK = '';

  failInit = false;

  constructor(private ventaService: VentaService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.ventaService.detalle(id).subscribe( data => {
      this.form.idVenta = data.idVenta;
      this.form.producto.idProducto = data.producto.idProducto;
      this.form.cliente.idCliente = data.cliente.idCliente;
      this.form.fechaVenta = data.fechaVenta;
      this.form.fechaCancelacion = data.fechaCancelacion;
      this.form.descripcion = data.descripcion;
      this.form.costo = data.costo;
      this.form.enganche = data.enganche;
    },
      (err: any) => {
        this.failInit = true;
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.ventaService.editar(this.form, id).subscribe( data => {
      this.actualizado = true;
      this.failActualizado = false;
      this.msjOK = data.mensaje;
    },
    (err: any) => {
      this.actualizado = false;
      this.failActualizado = true;
      this.msjErr = err.error.mensaje;
    }
    );
  }

  volver(): void {
    window.history.back();
  }

}