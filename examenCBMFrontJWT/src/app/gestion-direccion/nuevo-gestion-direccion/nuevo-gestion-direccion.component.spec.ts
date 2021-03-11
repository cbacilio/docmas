import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoGestionDireccionComponent } from './nuevo-gestion-direccion.component';

describe('NuevoGestionDireccionComponent', () => {
  let component: NuevoGestionDireccionComponent;
  let fixture: ComponentFixture<NuevoGestionDireccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoGestionDireccionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoGestionDireccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
