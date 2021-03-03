import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleAgregarAbonoComponent } from './detalle-agregar-abono.component';

describe('DetalleAgregarAbonoComponent', () => {
  let component: DetalleAgregarAbonoComponent;
  let fixture: ComponentFixture<DetalleAgregarAbonoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleAgregarAbonoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleAgregarAbonoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
