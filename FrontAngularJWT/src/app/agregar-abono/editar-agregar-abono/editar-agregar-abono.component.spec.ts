import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarAgregarAbonoComponent } from './editar-agregar-abono.component';

describe('EditarAgregarAbonoComponent', () => {
  let component: EditarAgregarAbonoComponent;
  let fixture: ComponentFixture<EditarAgregarAbonoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarAgregarAbonoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarAgregarAbonoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
