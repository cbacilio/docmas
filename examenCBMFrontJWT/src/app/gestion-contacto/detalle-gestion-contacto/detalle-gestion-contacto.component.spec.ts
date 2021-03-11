import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleGestionContactoComponent } from './detalle-gestion-contacto.component';

describe('DetalleGestionContactoComponent', () => {
  let component: DetalleGestionContactoComponent;
  let fixture: ComponentFixture<DetalleGestionContactoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleGestionContactoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleGestionContactoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
