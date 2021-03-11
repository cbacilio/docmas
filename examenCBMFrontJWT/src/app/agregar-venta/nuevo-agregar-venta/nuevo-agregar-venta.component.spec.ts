import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoAgregarVentaComponent } from './nuevo-agregar-venta.component';

describe('NuevoAgregarVentaComponent', () => {
  let component: NuevoAgregarVentaComponent;
  let fixture: ComponentFixture<NuevoAgregarVentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoAgregarVentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoAgregarVentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
