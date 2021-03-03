import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarGestionDireccionComponent } from './editar-gestion-direccion.component';

describe('EditarGestionDireccionComponent', () => {
  let component: EditarGestionDireccionComponent;
  let fixture: ComponentFixture<EditarGestionDireccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarGestionDireccionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarGestionDireccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
