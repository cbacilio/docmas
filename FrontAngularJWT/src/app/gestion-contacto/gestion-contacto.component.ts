import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { ContactoService } from '../services/contacto.service';
import { Contacto } from '../models/contacto';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-gestion-contacto',
  templateUrl: './gestion-contacto.component.html',
  styleUrls: ['./gestion-contacto.component.css']
})
export class GestionContactoComponent implements OnInit {
  @Input() user: string;

  contactos: Contacto[] = [];
  constructor(private contactoService: ContactoService) { }
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.cargarContactos();
  }

  cargarContactos(): void {
    this.contactoService.lista().subscribe(data => {
    this.contactos = data;
    //this.dataSource = new MatTableDataSource<contacto>(data);
     //this.dataSource.paginator = this.paginator;

    },
      (err: any) => {
        console.log(err);
      }
    );
  }

  onDelete(id: number): void {
    if (confirm('¿Estás seguro?')) {
      this.contactoService.borrar(id).subscribe(data => {
        this.cargarContactos();
      });
    }
  }
}
