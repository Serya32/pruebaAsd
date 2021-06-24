import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PATH_SAVE_ACTIVOS_FIJOS } from '../constants';
import { ActivoFijo } from '../model/activoFijo';

@Injectable({
  providedIn: 'root'
})
export class CrearActivoService {

  constructor(private http: HttpClient) { }

  
  /**
     * @author Alejandro Arias
     * @fecha 26/10/2020 
     * @desc Servicio que permite guardar los valores de las coberturas adicionales
     * @return void
     */
    saveActivosFijos( saveActivoFijo: ActivoFijo): Observable<any> {
      return this.http.post(PATH_SAVE_ACTIVOS_FIJOS, saveActivoFijo);
    }
}
