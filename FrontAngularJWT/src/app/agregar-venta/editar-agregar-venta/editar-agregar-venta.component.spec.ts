import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarAgregarVentaComponent } from './editar-agregar-venta.component';

describe('EditarAgregarVentaComponent', () => {
  let component: EditarAgregarVentaComponent;
  let fixture: ComponentFixture<EditarAgregarVentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarAgregarVentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarAgregarVentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
