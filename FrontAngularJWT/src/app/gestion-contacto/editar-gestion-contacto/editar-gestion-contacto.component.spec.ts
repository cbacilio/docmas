import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarGestionContactoComponent } from './editar-gestion-contacto.component';

describe('EditarGestionContactoComponent', () => {
  let component: EditarGestionContactoComponent;
  let fixture: ComponentFixture<EditarGestionContactoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarGestionContactoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarGestionContactoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
