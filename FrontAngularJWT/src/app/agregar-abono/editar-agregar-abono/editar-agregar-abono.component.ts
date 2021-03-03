import { Component, OnInit } from '@angular/core';
import { AbonoService } from '../../services/abono.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-editar-agregar-abono',
  templateUrl: './editar-agregar-abono.component.html',
  styleUrls: ['./editar-agregar-abono.component.css']
})
export class EditarAgregarAbonoComponent implements OnInit {
  form: any = {};
  actualizado = false;
  failActualizado = false;
  msjErr = '';
  msjOK = '';

  failInit = false;

  constructor(private abonoService: AbonoService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.abonoService.detalle(id).subscribe( data => {
      this.form.venta.idVenta = data.venta.idVenta ;
      this.form.monto = data.monto;
      this.form.fecha = data.fecha;

    },
      (err: any) => {
        this.failInit = true;
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.abonoService.editar(this.form, id).subscribe( data => {
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