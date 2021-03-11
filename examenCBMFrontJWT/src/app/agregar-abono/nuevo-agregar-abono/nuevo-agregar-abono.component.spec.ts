import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoAgregarAbonoComponent } from './nuevo-agregar-abono.component';

describe('NuevoAgregarAbonoComponent', () => {
  let component: NuevoAgregarAbonoComponent;
  let fixture: ComponentFixture<NuevoAgregarAbonoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoAgregarAbonoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoAgregarAbonoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
