import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoGestionContactoComponent } from './nuevo-gestion-contacto.component';

describe('NuevoGestionContactoComponent', () => {
  let component: NuevoGestionContactoComponent;
  let fixture: ComponentFixture<NuevoGestionContactoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoGestionContactoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoGestionContactoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
