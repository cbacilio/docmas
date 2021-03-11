import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleGestionDireccionComponent } from './detalle-gestion-direccion.component';

describe('DetalleGestionDireccionComponent', () => {
  let component: DetalleGestionDireccionComponent;
  let fixture: ComponentFixture<DetalleGestionDireccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleGestionDireccionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleGestionDireccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
