import { Component, OnInit } from '@angular/core';
import { Direccion } from '../../models/direccion';
import { DireccionService } from '../../services/direccion.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalle-gestion-direccion',
  templateUrl: './detalle-gestion-direccion.component.html',
  styleUrls: ['./detalle-gestion-direccion.component.css']
})
export class DetalleGestionDireccionComponent implements OnInit {

  
  direccion: Direccion = null;

  constructor(private direccionService: DireccionService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.direccionService.detalle(id).subscribe(data => {
      this.direccion = data;
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
