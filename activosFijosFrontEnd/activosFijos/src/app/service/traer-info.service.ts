import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PATH_GET_ACTIVOS_FIJOS, PATH_GET_ACTIVO_FIJO_BY_ID, PATH_GET_AREA, PATH_GET_CIUDAD, PATH_GET_PERSONA, PATH_GET_TIPO } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class TraerInfoService {

  constructor(private http: HttpClient) { 

  }
  getPersona(): Observable<any> {
    return this.http.get(PATH_GET_PERSONA);
  }

  getCiudades(): Observable<any> {
    return this.http.get(PATH_GET_CIUDAD);
  }
  getTipos(): Observable<any> {
    return this.http.get(PATH_GET_TIPO);
  }

  getArea(): Observable<any> {
    return this.http.get(PATH_GET_AREA);
  }

  getActivosFijos(): Observable<any> {
    return this.http.get(PATH_GET_ACTIVOS_FIJOS);
  }
  getActivosFijosById(id: number): Observable<any> {
    return this.http.get(PATH_GET_ACTIVO_FIJO_BY_ID+id);
  }

 
}
