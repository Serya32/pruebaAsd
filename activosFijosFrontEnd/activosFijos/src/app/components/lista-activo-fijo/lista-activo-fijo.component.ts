import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivoFijo } from 'src/app/model/activoFijo';
import { MatTableFilter } from 'mat-table-filter';
import { DatePipe } from '@angular/common';

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


  displayedColumns = ['id', 'nombreTipo', 'fechaFiltro', 'serial'];
  // dataSource = new MatTableDataSource();
  // 'serial', 'peso','alto','ancho', 'largo', 'valor Compra', 'fhecha Compra', 'numero interno'
  arrHistorial: ActivoFijo[] = [];
  constructor(public datepipe: DatePipe) { }

  ngOnInit(): void {

    this.getListaActivos();
    console.log(this.arrHistorial);
    this.filterEntity = new SpaceCraft();
    // this.filterEntity.captain = new Captain();
    this.filterType = MatTableFilter.ANYWHERE;
    this.dataSource = new MatTableDataSource(this.arrHistorial);
 
 
  }
  
  getListaActivos(){

    const activoObject: ActivoFijo = new ActivoFijo();
    activoObject.id = 1
    activoObject.idAsignacion = 2
    activoObject.nombreTipo = 'hola'
    activoObject.nombre = 'mesita';
    activoObject.descripcion = 'mesa de escritorio';
    activoObject.serial = '23333333Hs';
    activoObject.numeroInternoInventario = 22;
    activoObject.peso = 22.2;
    activoObject.alto = 21.1;
    activoObject.ancho = 21.2;
    activoObject.largo = 22.3;
    activoObject.valorCompra = 22.4; 
    activoObject.fechaCompra = new Date();
    this.date=new Date();
    activoObject.fechaFiltro = this.datepipe.transform(this.date, 'dd/MM/yyyy');

    const activoObjects: ActivoFijo = new ActivoFijo();
    activoObjects.id = 2
    activoObjects.idAsignacion = 2
    activoObjects.nombreTipo = 'perro'
    activoObjects.nombre = 'messa';
    activoObjects.descripcion = 'mesa de escritorio';
    activoObjects.serial = '33333333Hs';
    activoObjects.numeroInternoInventario = 22;
    activoObjects.peso = 22.2;
    activoObjects.alto = 21.1;
    activoObjects.ancho = 21.2;
    activoObjects.largo = 22.3;
    activoObjects.valorCompra = 22.4;
    activoObjects.fechaCompra = new Date();
    this.date=new Date();
    activoObjects.fechaFiltro = this.datepipe.transform(this.date, 'dd/MM/yyyy');
    this.arrHistorial.push(activoObject);
    this.arrHistorial.push(activoObjects);
    this.dataSource = new MatTableDataSource(this.arrHistorial);
  }

}

export class SpaceCraft {
  nombreTipo: string;
  serial: number;
  fechaFiltro: string;
}



