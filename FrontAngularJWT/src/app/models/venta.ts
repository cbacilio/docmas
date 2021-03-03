import { Producto } from '../models/producto';
import { Cliente } from '../models/cliente';
export class Venta{

    idVenta:number;
	producto:Producto;
    cliente:Cliente;
	saldo:number;
	fechaVenta:Date;
	fechaCancelacion:Date;
	descripcion:Date;
	costo:number;
	enganche:number;

}