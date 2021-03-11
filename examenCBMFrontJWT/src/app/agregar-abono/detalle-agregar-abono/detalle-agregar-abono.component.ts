import { Component, OnInit } from '@angular/core';
import { Abono } from '../../models/abono';
import { AbonoService } from '../../services/abono.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalle-agregar-abono',
  templateUrl: './detalle-agregar-abono.component.html',
  styleUrls: ['./detalle-agregar-abono.component.css']
})
export class DetalleAgregarAbonoComponent implements OnInit {

  
  abono: Abono = null;

  constructor(private abonoService: AbonoService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.abonoService.detalle(id).subscribe(data => {
      this.abono = data;
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
