import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoGestionProductoComponent } from './nuevo-gestion-producto.component';

describe('NuevoGestionProductoComponent', () => {
  let component: NuevoGestionProductoComponent;
  let fixture: ComponentFixture<NuevoGestionProductoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoGestionProductoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoGestionProductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
