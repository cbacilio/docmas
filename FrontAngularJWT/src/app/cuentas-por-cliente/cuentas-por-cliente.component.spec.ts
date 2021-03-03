import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuentasPorClienteComponent } from './cuentas-por-cliente.component';

describe('CuentasPorClienteComponent', () => {
  let component: CuentasPorClienteComponent;
  let fixture: ComponentFixture<CuentasPorClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuentasPorClienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CuentasPorClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
