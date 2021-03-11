import { Component, OnInit } from '@angular/core';
import { Contacto } from '../../models/contacto';
import { ContactoService } from '../../services/contacto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalle-gestion-contacto',
  templateUrl: './detalle-gestion-contacto.component.html',
  styleUrls: ['./detalle-gestion-contacto.component.css']
})
export class DetalleGestionContactoComponent implements OnInit {

  
  contacto: Contacto = null;

  constructor(private contactoService: ContactoService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.contactoService.detalle(id).subscribe(data => {
      this.contacto = data;
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
