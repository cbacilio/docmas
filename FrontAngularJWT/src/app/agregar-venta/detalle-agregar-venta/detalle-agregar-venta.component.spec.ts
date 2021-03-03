import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleAgregarVentaComponent } from './detalle-agregar-venta.component';

describe('DetalleAgregarVentaComponent', () => {
  let component: DetalleAgregarVentaComponent;
  let fixture: ComponentFixture<DetalleAgregarVentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleAgregarVentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleAgregarVentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
