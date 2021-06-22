import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivoFijo } from 'src/app/model/activoFijo';
import { MatTableFilter } from 'mat-table-filter';

@Component({
  selector: 'app-lista-activo-fijo',
  templateUrl: './lista-activo-fijo.component.html',
  styleUrls: ['./lista-activo-fijo.component.css'],
  encapsulation: ViewEncapsulation.None

})
export class ListaActivoFijoComponent implements OnInit {
  filterEntity: SpaceCraft;
  filterType: MatTableFilter;
  dataSource;



  displayedColumns = ['id', 'nombreTipo', 'fechaCompra', 'serial'];
  // dataSource = new MatTableDataSource();
  // 'serial', 'peso','alto','ancho', 'largo', 'valor Compra', 'fhecha Compra', 'numero interno'
  arrHistorial: ActivoFijo[] = [];
  constructor() { }

  ngOnInit(): void {

    this.getListaActivos();
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



    this.arrHistorial.push(activoObject);
    this.arrHistorial.push(activoObjects);
    this.dataSource = new MatTableDataSource(this.arrHistorial);
    console.log(this.dataSource)
    console.log(this.arrHistorial)
  }

}

export class SpaceCraft {
  nombreTipo: string;
  serial: number;
  fechaCompra: Date;
}

// const SPACECRAFT_DATA: SpaceCraft[] = [
//   {nombreTipo: 'Endurance', serial: 2, fechaCompra: JSON.stringify(new Date())},
//   {nombreTipo: 'Enterprise', serial: 2,  fechaCompra: JSON.stringify(new Date())},
//   {nombreTipo: 'Discovery', serial: 2,  fechaCompra: JSON.stringify(new Date())},
//   {nombreTipo: 'Enterprise', serial: 2,  fechaCompra: JSON.stringify(new Date())}
// ];

// $(document).ready(function(){
//   $("#myInput").on("keyup", function() {
//     var value = $(this).val().toLowerCase();
//     $("#myList li").filter(function() {
//       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
//     });
//   });
// });


