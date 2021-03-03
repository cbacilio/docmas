import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { Venta } from '../../models/venta';
import { VentaService } from '../../services/venta.service';
import { ClienteService } from '../../services/cliente.service';
import { Cliente } from '../../models/cliente';
import { FormControl } from '@angular/forms';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';


@Component({
  selector: 'app-nuevo-agregar-venta',
  templateUrl: './nuevo-agregar-venta.component.html',
  styleUrls: ['./nuevo-agregar-venta.component.css']
})
export class NuevoAgregarVentaComponent implements OnInit {

  form: any = {};
  venta: Venta;
  creado = false;
  failVenta = false;
  mensajeFail = '';
  mensajeOK = '';

  idProducto: string = "Producto";
  
  selectedCountryControl = new FormControl(this.idProducto);

  constructor(
    private ventaService: VentaService, 
    private productoService: ProductoService,
    private clienteService: ClienteService) { }

 
  productos: Producto[] = [];
  clientes: Cliente[] = [];
  ngOnInit() {
    this.cargarProductos();
    this.cargarClientes();
  }

  cargarProductos(): void {
    console.log("Inicia la carga de productos");
    this.productoService.lista().subscribe(data => {
    this.productos = data;
    //this.dataSource = new MatTableDataSource<Producto>(data);
     //this.dataSource.paginator = this.paginator;

    },
      (err: any) => {
        console.log(err);
      }
    );
  }

  cargarClientes(): void {
    this.clienteService.lista().subscribe(data => {
    this.clientes = data;
    },
      (err: any) => {
        console.log(err);
      }
    );
  }

  onCreate(): void {
    this.ventaService.crear(this.form).subscribe(data => {
      console.log(data);
      this.mensajeOK = data.mensaje;
      this.creado = true;
      this.failVenta = false;
    },
      (err: any) => {
        this.mensajeFail = err.error.mensaje;
        this.creado = false;
        this.failVenta = true;
      }
    );
  }

  volver(): void {
    window.history.back();
  }

}