import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleGestionProductoComponent } from './detalle-gestion-producto.component';

describe('DetalleGestionProductoComponent', () => {
  let component: DetalleGestionProductoComponent;
  let fixture: ComponentFixture<DetalleGestionProductoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleGestionProductoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleGestionProductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
