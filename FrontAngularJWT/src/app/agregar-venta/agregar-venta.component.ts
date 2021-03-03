import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { VentaService } from '../services/venta.service';
import { Venta } from '../models/Venta';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-agregar-venta',
  templateUrl: './agregar-venta.component.html',
  styleUrls: ['./agregar-venta.component.css']
})
export class AgregarVentaComponent implements OnInit {
  @Input() user: string;

  ventas: Venta[] = [];
  constructor(private ventaService: VentaService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

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

  onDelete(id: number): void {
    if (confirm('¿Estás seguro?')) {
      this.ventaService.borrar(id).subscribe(data => {
        this.cargarVentas();
      });
    }
  }
}
