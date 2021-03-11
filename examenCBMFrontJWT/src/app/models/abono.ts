import { Venta } from '../models/venta';
import { Cliente } from '../models/cliente';
export class Abono {

    idAbono: number;
    venta: Venta;
    monto: number;
    fecha: Date;
    
}
