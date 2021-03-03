import { Component, OnInit } from '@angular/core';
import { Venta } from '../../models/venta';
import { VentaService } from '../../services/venta.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-detalle-agregar-venta',
  templateUrl: './detalle-agregar-venta.component.html',
  styleUrls: ['./detalle-agregar-venta.component.css']
})
export class DetalleAgregarVentaComponent implements OnInit {

  venta: Venta = null;

  constructor(private ventaService: VentaService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.ventaService.detalle(id).subscribe(data => {
      this.venta = data;
    },
      err => {
        this.router.navigate(['']);
      }
    );
  }

  volver(): void {
    window.history.back();
  }

}
