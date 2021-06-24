import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CODIGO_AREA, CODIGO_PERSONA } from 'src/app/constants';
import { ActivoFijo } from 'src/app/model/activoFijo';
import { Area } from 'src/app/model/area';
import { Ciudad } from 'src/app/model/ciudad';
import { Persona } from 'src/app/model/persona';
import { Tipo } from 'src/app/model/tipo';

@Component({
  selector: 'app-crear-activo-fijo',
  templateUrl: './crear-activo-fijo.component.html',
  styleUrls: ['./crear-activo-fijo.component.css']
})
export class CrearActivoFijoComponent implements OnInit {

  formCrearActivo: FormGroup;
  tipoActivo: Tipo[] = [];
  areaAginada: Area[] = [];
  ciudadArea: Ciudad[] = [];
  selectCiudad: Ciudad[] = [];
  arrayPersona: Persona[] = [];
  activoNuevo: ActivoFijo;
  showArea = false;
  selectPersona: number;
  selectArea: number;
  nombreCiudad: string;
  nombreArea: string;
  nombrePersona: string;
  nombreTipo: string

  constructor() { }

  ngOnInit(): void {
    this.tipo();
    this.areaSeleccionada();
    this.arregloPersona();
    this.formCrearActivo = new FormGroup({
      nombreActivo: new FormControl('',[Validators.required]),
      descripcion: new FormControl('',[Validators.required]),
      tipoNombre: new FormControl('',[Validators.required]),
      numInventario: new FormControl('',[Validators.required]),
      peso: new FormControl('',[Validators.required]),
      alto: new FormControl('',[Validators.required]),
      ancho: new FormControl('',[Validators.required]),
      largo: new FormControl('',[Validators.required]),
      valCompra: new FormControl('',[Validators.required]),
      fechaCompra: new FormControl('',[Validators.required]),
      persona: new FormControl('',[Validators.required]),
      area: new FormControl(0,[Validators.required]),
      ciudad: new FormControl('',[Validators.required]),
      personaSelect: new FormControl('',[Validators.required]),

    })
  }

  get nombreActivo() { return this.formCrearActivo.get('nombreActivo'); }
  get descripcion() { return this.formCrearActivo.get('descripcion'); }
  get tipoNombre() { return this.formCrearActivo.get('tipoNombre'); }
  get numInventario() { return this.formCrearActivo.get('numInventario'); }
  get peso() { return this.formCrearActivo.get('peso'); }
  get alto() { return this.formCrearActivo.get('alto'); }
  get largo() { return this.formCrearActivo.get('largo'); }
  get ancho() { return this.formCrearActivo.get('ancho'); }
  get valCompra() { return this.formCrearActivo.get('valCompra'); }
  get fechaCompra() { return this.formCrearActivo.get('fechaCompra'); }
  get persona() { return this.formCrearActivo.get('persona'); }
  get area() { return this.formCrearActivo.get('area'); }
  get ciudad() { return this.formCrearActivo.get('ciudad'); }
  get personaSelect() { return this.formCrearActivo.get('personaSelect'); }



  tipo(){
    const activoObject: Tipo = new Tipo();
    activoObject.idTipo = 1;
    activoObject.nombreTipo = 'Mesa';
    const activoObjects: Tipo = new Tipo();
    activoObjects.idTipo = 2;
    activoObjects.nombreTipo = 'Esfero';
    this.tipoActivo.push(activoObject)
    this.tipoActivo.push(activoObjects)
    
  }

  areaSeleccionada(){
    const activoObject: Area = new Area();
    activoObject.idArea = 1;
    activoObject.idCiudad = 1;
    activoObject.nombreArea = 'Mercadeo';
    const activoObjects: Area = new Area();
    activoObjects.idArea = 2;
    activoObjects.idCiudad = 2;
    activoObjects.nombreArea = 'Tecnologia';
    this.areaAginada.push(activoObject)
    this.areaAginada.push(activoObjects)
  }

  arregloPersona(){
    const activoObject: Persona = new Persona();
    activoObject.idPersona = 1;
    activoObject.nombrePersona = 'Claudia';
    const activoObjects: Persona = new Persona();
    activoObjects.idPersona = 2;
    activoObjects.nombrePersona = 'Andres';
    this.arrayPersona.push(activoObject)
    this.arrayPersona.push(activoObjects)
  }
  
  getCiudad(idArea: number){
    this.ciudadArea = [];
    const activoObject: Ciudad = new Ciudad();
    activoObject.idCiudad = 1;
    activoObject.nombreCiudad = 'Bogota';
    const activoObjects: Ciudad = new Ciudad();
    activoObjects.idCiudad = 2;
    activoObjects.nombreCiudad = 'Mosquera';
    this.ciudadArea.push(activoObject)
    this.ciudadArea.push(activoObjects)
    this.areaAginada.forEach(element => {
      if (element.idArea === +idArea) {
        this.ciudadArea.forEach(ciudad => {
          if (ciudad.idCiudad === element.idCiudad) {
            this.selectCiudad = [];
            const selectOption = new Ciudad();
            selectOption.idCiudad = ciudad.idCiudad;
            selectOption.nombreCiudad = ciudad.nombreCiudad;
            this.selectCiudad.push(selectOption)
            this.ciudad.setValue(ciudad.idCiudad);
            this.nombreCiudad = ciudad.nombreCiudad;
            this.nombreArea = element.nombreArea;
          }
        });
      }
    });
  
  }

  getPersona(code: number) {
    this.arrayPersona.forEach(element => {
      if (element.idPersona === +code) {
        console.log(this.tipoNombre.value);
        this.nombrePersona = element.nombrePersona;
      }
    });
  }
  getArea(code: number){
    if (code === CODIGO_AREA) {
      this.showArea = true;
      this.persona.setValue(null)
      this.area.setValue('');
      this.ciudad.setValue('');
      this.personaSelect.setValue(null)
      this.nombrePersona = null;
      this.selectArea = 1;
      this.selectPersona = null;
    } else if (code === CODIGO_PERSONA) {
      this.showArea = false;
      this.area.setValue(null);
      this.ciudad.setValue(null);
      this.persona.setValue('');
      this.selectArea = null;
      this.selectPersona = 0;
    }
  }

  getTipo(code: number){
    
    this.tipoActivo.forEach(element => {
      if (element.idTipo === +code) {
        console.log(this.tipoNombre.value);
        this.nombreTipo = element.nombreTipo;
      }
    });
  }

  getDatos(){
    this.activoNuevo = new ActivoFijo();
    this.activoNuevo.nombre = this.nombreActivo.value;
    this.activoNuevo.descripcion = this.descripcion.value;
    this.activoNuevo.nombreTipo = this.nombreTipo;
    this.activoNuevo.peso = +this.peso.value;
    this.activoNuevo.alto = +this.alto.value;
    this.activoNuevo.largo = +this.largo.value;
    this.activoNuevo.ancho = +this.ancho.value;
    this.activoNuevo.numeroInternoInventario = +this.numInventario.value;
    this.activoNuevo.valorCompra = +this.valCompra.value;
    this.activoNuevo.fechaCompra = this.fechaCompra.value;
    this.activoNuevo.persona = this.selectPersona;
    this.activoNuevo.area = this.selectArea;
    if (this.personaSelect.value !== null) {
      this.activoNuevo.idPersona = +this.personaSelect.value;
    } else {
      this.activoNuevo.idPersona = this.personaSelect.value;
    }
    this.activoNuevo.personaNombre = this.nombrePersona;
    if (this.area.value !== null) {
      this.activoNuevo.idArea = +this.area.value;
    } else {
      this.activoNuevo.idArea = this.area.value;
    }
    this.activoNuevo.areaNombre = this.nombreArea;
    if (this.ciudad.value !== null) {
      this.activoNuevo.idCiudad = +this.ciudad.value;
    } else {
      this.activoNuevo.idCiudad = this.ciudad.value;
    }
    this.activoNuevo.ciudadNombre = this.nombreCiudad;
    console.log(this.activoNuevo, "respuesta");
  }
}
