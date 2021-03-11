import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarGestionProductoComponent } from './editar-gestion-producto.component';

describe('EditarGestionProductoComponent', () => {
  let component: EditarGestionProductoComponent;
  let fixture: ComponentFixture<EditarGestionProductoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarGestionProductoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarGestionProductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
