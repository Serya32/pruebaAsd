import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivoFijo } from 'src/app/model/activoFijo';
import { MatTableFilter } from 'mat-table-filter';
import { DatePipe } from '@angular/common';
import { TraerInfoService } from 'src/app/service/traer-info.service';
import { Area } from 'src/app/model/area';
import { Tipo } from 'src/app/model/tipo';
import { Ciudad } from 'src/app/model/ciudad';
import { Persona } from 'src/app/model/persona';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-activo-fijo',
  templateUrl: './lista-activo-fijo.component.html',
  styleUrls: ['./lista-activo-fijo.component.css'],
  providers: [DatePipe],
  encapsulation: ViewEncapsulation.None

})
export class ListaActivoFijoComponent implements OnInit {
  filterEntity: SpaceCraft;
  filterType: MatTableFilter;
  dataSource;
  date;
  tipoActivo: Tipo[] = [];
  areaAginada: Area[] = [];
  ciudadArea: Ciudad[] = [];
  arrayPersona: Persona[] = [];


  displayedColumns = ['id', 'nombre', 'nombreTipo', 'fechaFiltro', 'serial', 'peso', 'alto', 'ancho', 'asignado', 'actualizar'];
  arrHistorial: ActivoFijo[] = [];
  constructor(public datepipe: DatePipe, private traerInfoService: TraerInfoService,
    private router: Router,
    ) { }

  ngOnInit(): void {
    if (localStorage.getItem('usuarioSucursalId') !== null && localStorage.getItem('usuarioSucursalId') !== undefined) {
      localStorage.removeItem('usuarioSucursalId');
    }
    
    this.getListaActivos();
    this.filterEntity = new SpaceCraft();
    this.filterType = MatTableFilter.ANYWHERE;
    this.dataSource = new MatTableDataSource(this.arrHistorial);
 
 
  }

  getListaActivos(){
    this.traerInfoService.getActivosFijos().subscribe(response=>{
      
      this.arrHistorial = response
      this.arrHistorial.forEach(element => {
        let fecha = new Date(element.fechaCompra).toISOString().substring(0, new Date(element.fechaCompra).toISOString().length - 1);
        element.fechaFiltro = this.datepipe.transform(fecha, 'dd/MM/yyyy');
      });
      this.tipo();
      this.areaSeleccionada();
      this.arregloPersona();
      this.getCiudad();
      console.log(this.arrHistorial )
      this.dataSource = new MatTableDataSource(this.arrHistorial); 
      });
      
  }


  tipo(){
    this.traerInfoService.getTipos().subscribe(response=>{
      this.tipoActivo = response;
      this.arrHistorial.forEach(element => {
      this.tipoActivo.forEach(tipo => {
        if (element.idTipo === tipo.id) {
          element.nombreTipo = tipo.nombre;
        }
        if (element.idArea !== null) {
          element.area = 1;
          element.asignacion = 'Area';
        } else if (element.idPersona !== null){
          element.persona = 0;
          element.asignacion = 'Persona';

        }
      });
    });
    });
  }

  areaSeleccionada(){
    this.traerInfoService.getArea().subscribe(response=>{
      this.areaAginada = response;
      this.arrHistorial.forEach(element => {
        this.areaAginada.forEach(area => {
          if (element.idArea === area.id) {
            element.areaNombre = area.nombre;
          }
        });
      });
    })
  }

  arregloPersona(){
    this.traerInfoService.getPersona().subscribe(response =>{
      this.arrayPersona = response;
      this.arrHistorial.forEach(element => {
        this.arrayPersona.forEach(persona => {
          if (element.idPersona === persona.id) {
            element.personaNombre = persona.nombres;
          }
        });
      });
    })
  }

  getCiudad(){
    this.ciudadArea = [];  
    this.traerInfoService.getCiudades().subscribe(response=>{ 
        this.ciudadArea = response;
        this.arrHistorial.forEach(element => {
          this.ciudadArea.forEach(ciudad => {
            if (element.idCiudad === ciudad.id) {
              element.ciudadNombre = ciudad.nombre;
            }
          });
        });
    })
  }

  actifoFijoById(id: number){
    localStorage.setItem('usuarioSucursalId', JSON.stringify(id));
    this.router.navigate(['/crear']);
    console.log(localStorage.getItem('usuarioSucursalId'))
  }

}

export class SpaceCraft {
  nombreTipo: string;
  serial: number;
  fechaFiltro: string;
}



