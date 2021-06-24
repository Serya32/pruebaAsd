import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CODIGO_AREA, CODIGO_PERSONA } from 'src/app/constants';
import { ActivoFijo } from 'src/app/model/activoFijo';
import { Area } from 'src/app/model/area';
import { Ciudad } from 'src/app/model/ciudad';
import { Persona } from 'src/app/model/persona';
import { Tipo } from 'src/app/model/tipo';
import { CrearActivoService } from 'src/app/service/crear-activo.service';
import { TraerInfoService } from 'src/app/service/traer-info.service';

@Component({
  selector: 'app-crear-activo-fijo',
  templateUrl: './crear-activo-fijo.component.html',
  styleUrls: ['./crear-activo-fijo.component.css'],
  providers: [DatePipe],

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
  id : number;

  constructor(
    private traerInfoService: TraerInfoService,
    private crearActivoService: CrearActivoService,
    public datepipe: DatePipe,
    private router: Router,
     ) { }

  ngOnInit(): void {
    this.tipo();
    this.areaSeleccionada();
    this.arregloPersona();

    if (localStorage.getItem('usuarioSucursalId') !== null && localStorage.getItem('usuarioSucursalId') !== undefined) {
      this.id = +localStorage.getItem('usuarioSucursalId');
      this.traerInfoService.getActivosFijosById(this.id).subscribe(response=>{
        this.setActivosFijos(response);
      })

    }
    this.formCrearActivo = new FormGroup({
      nombreActivo: new FormControl('',[Validators.required]),
      descripcion: new FormControl('',[Validators.required]),
      tipoNombre: new FormControl('',[Validators.required]),
      numInventario: new FormControl('',[Validators.required]),
      peso: new FormControl('',[Validators.required]),
      alto: new FormControl('',[Validators.required]),
      ancho: new FormControl('',[Validators.required]),
      largo: new FormControl('',[Validators.required]),
      serial: new FormControl('',[Validators.required]),
      valCompra: new FormControl('',[Validators.required]),
      fechaCompra: new FormControl('',[Validators.required]),
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
  get area() { return this.formCrearActivo.get('area'); }
  get ciudad() { return this.formCrearActivo.get('ciudad'); }
  get personaSelect() { return this.formCrearActivo.get('personaSelect'); }
  get serial() { return this.formCrearActivo.get('serial'); }



  tipo(){
    this.traerInfoService.getTipos().subscribe(response=>{
      this.tipoActivo = response;
   
    })
  }

  areaSeleccionada(){

    this.traerInfoService.getArea().subscribe(response=>{
      this.areaAginada = response;
    })
  }

  arregloPersona(){
    this.traerInfoService.getPersona().subscribe(response =>{
      this.arrayPersona = response;
    
    })
  }
  
  getCiudad(idArea: number){
    this.ciudadArea = [];  
    this.traerInfoService.getCiudades().subscribe(response=>{ 
        this.ciudadArea = response;
        this.areaAginada.forEach(elements => {
          if (elements.id === +idArea) {
            this.ciudadArea.forEach(ciudad => {
              if (ciudad.id === elements.id) {
                this.selectCiudad = [];
                this.selectCiudad.push(ciudad)
                this.ciudad.setValue(ciudad.id);
                this.nombreCiudad = ciudad.nombre;
                this.nombreArea = elements.nombre;
              }
            });
          }
        });
  
  });
  
  }

  getPersona(code: number) {
    this.arrayPersona.forEach(element => {
      if (element.id === +code) {
        console.log(this.tipoNombre.value);
        this.nombrePersona = element.nombres;
      }
    });
  }
  getArea(code: number){
    if (code === CODIGO_AREA) {
      this.showArea = true;
      this.area.setValue('');
      this.ciudad.setValue('');
      this.personaSelect.setValue(null)
      this.personaSelect.disable();
      this.ciudad.enable();
      this.area.enable();
      this.nombrePersona = null;
      this.selectArea = 1;
      this.selectPersona = null;
    } else if (code === CODIGO_PERSONA) {
      this.showArea = false;
      this.area.setValue(null);
      this.ciudad.setValue(null);
      this.ciudad.disable();
      this.area.disable();
      this.personaSelect.enable();
      this.personaSelect.setValue('')
      this.selectArea = null;
      this.selectPersona = 0;
    }
  }

  getTipo(code: number){
    
    this.tipoActivo.forEach(element => {
      if (element.id === +code) {
        this.nombreTipo = element.nombre;
      }
    });
  }


  setActivosFijos(activoNuevo: ActivoFijo){

    this.nombreActivo.setValue(activoNuevo.nombre)
    this.descripcion.setValue(activoNuevo.descripcion);
    this.tipoNombre.setValue(activoNuevo.idTipo);
    this.numInventario.setValue(activoNuevo.numeroInternoInventario);
    this.peso.setValue(activoNuevo.peso);
    this.alto.setValue(activoNuevo.alto);
    this.largo.setValue(activoNuevo.largo);
    this.ancho.setValue(activoNuevo.ancho);
    this.valCompra.setValue(activoNuevo.valorCompra);
    let fecha = new Date(activoNuevo.fechaCompra).toISOString().substring(0, new Date(activoNuevo.fechaCompra).toISOString().length - 1);
    let fechaTransform = this.datepipe.transform(fecha, 'yyyy-MM-dd')
    this.fechaCompra.setValue(fechaTransform);
    this.area.setValue(activoNuevo.idArea);
    this.ciudad.setValue(activoNuevo.idCiudad);
    this.personaSelect.setValue(activoNuevo.idPersona);
    this.serial.setValue(activoNuevo.serial);
    this.setArea(activoNuevo);
  }
  setArea(activoNuevo: ActivoFijo) {
    if (this.personaSelect.value !== null) {
      this.selectPersona = 0;
      this.selectArea = null;
      this.showArea = false;
      this.personaSelect.setValue(activoNuevo.idPersona);
      this.ciudad.disable();
      this.area.disable();
    } else if(this.area.value !== null) {
      this.showArea = true;
      this.selectPersona = null;
      this.selectArea = 1;
      this.area.setValue(activoNuevo.idArea);
      this.getCiudad(activoNuevo.idArea);
      this.personaSelect.disable();
      
    }
  }
  getDatos(){
    this.activoNuevo = new ActivoFijo();
    if (localStorage.getItem('usuarioSucursalId') !== null && localStorage.getItem('usuarioSucursalId') !== undefined) {
    this.activoNuevo.id = +localStorage.getItem('usuarioSucursalId');
    }
    this.activoNuevo.nombre = this.nombreActivo.value;
    this.activoNuevo.descripcion = this.descripcion.value;
    this.activoNuevo.nombreTipo = this.nombreTipo;
    this.activoNuevo.idTipo = +this.tipoNombre.value;
    this.activoNuevo.peso = +this.peso.value;
    this.activoNuevo.alto = +this.alto.value;
    this.activoNuevo.largo = +this.largo.value;
    this.activoNuevo.ancho = +this.ancho.value;
    this.activoNuevo.serial = this.serial.value;
    this.activoNuevo.numeroInternoInventario = +this.numInventario.value;
    this.activoNuevo.valorCompra = +this.valCompra.value;
    this.activoNuevo.fechaCompra = this.fechaCompra.value;
    this.activoNuevo.fechaFiltro = this.fechaCompra.value;
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

    this.saveActivoFijo(this.activoNuevo);

  }

  saveActivoFijo(activoNuevo: ActivoFijo){
    this.crearActivoService.saveActivosFijos(activoNuevo).subscribe(response=>{
      this.router.navigate(['/listarActivo']);
      console.log(response);
    })
  }
}
