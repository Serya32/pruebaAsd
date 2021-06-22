import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ListaActivoFijoComponent } from './lista-activo-fijo.component';


describe('ListaActivoFijoComponent', () => {
  let component: ListaActivoFijoComponent;
  let fixture: ComponentFixture<ListaActivoFijoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaActivoFijoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaActivoFijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
