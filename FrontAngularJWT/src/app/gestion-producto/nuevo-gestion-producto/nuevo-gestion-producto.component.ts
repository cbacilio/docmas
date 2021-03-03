import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';

@Component({
  selector: 'app-nuevo-gestion-producto',
  templateUrl: './nuevo-gestion-producto.component.html',
  styleUrls: ['./nuevo-gestion-producto.component.css']
})
export class NuevoGestionProductoComponent implements OnInit {
    form: any = {};
    producto: Producto;
    creado = false;
    failProducto = false;
    mensajeFail = '';
    mensajeOK = '';
  
    constructor(private productoService: ProductoService) { }
  
    ngOnInit() {
    }
  
    onCreate(): void {
      this.productoService.crear(this.form).subscribe(data => {
        this.mensajeOK = data.mensaje;
        this.creado = true;
        this.failProducto = false;
      },
        (err: any) => {
          this.mensajeFail = err.error.mensaje;
          this.creado = false;
          this.failProducto = true;
        }
      );
    }
  
    volver(): void {
      window.history.back();
    }
  
  }