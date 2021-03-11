import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { AbonoService } from '../services/abono.service';
import { Abono } from '../models/abono';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-agregar-abono',
  templateUrl: './agregar-abono.component.html',
  styleUrls: ['./agregar-abono.component.css']
})
export class AgregarAbonoComponent implements OnInit {
  @Input() user: string;

  abonos: Abono[] = [];
  constructor(private abonoService: AbonoService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.cargarAbonos();
  }

  cargarAbonos(): void {
    this.abonoService.lista().subscribe(data => {
    this.abonos = data;
    },
      (err: any) => {
        console.log(err);
      }
    );
  }

  onDelete(id: number): void {
    if (confirm('¿Estás seguro?')) {
      this.abonoService.borrar(id).subscribe(data => {
        this.cargarAbonos();
      });
    }
  }
}
