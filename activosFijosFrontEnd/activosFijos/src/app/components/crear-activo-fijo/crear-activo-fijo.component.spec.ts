import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearActivoFijoComponent } from './crear-activo-fijo.component';

describe('CrearActivoFijoComponent', () => {
  let component: CrearActivoFijoComponent;
  let fixture: ComponentFixture<CrearActivoFijoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearActivoFijoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearActivoFijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
