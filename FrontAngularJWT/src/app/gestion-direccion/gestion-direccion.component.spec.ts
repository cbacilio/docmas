import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionDireccionComponent } from './gestion-direccion.component';

describe('GestionDireccionComponent', () => {
  let component: GestionDireccionComponent;
  let fixture: ComponentFixture<GestionDireccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionDireccionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionDireccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
