import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaActivoFijoComponent } from './components/lista-activo-fijo/lista-activo-fijo.component';
import {MatSelectModule} from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule  } from '@angular/material/form-field';
import { MatInputModule  } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableFilterModule } from 'mat-table-filter';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CrearActivoFijoComponent } from './components/crear-activo-fijo/crear-activo-fijo.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaActivoFijoComponent,
    CrearActivoFijoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableFilterModule,
    FormsModule,
    ReactiveFormsModule,
    MatSelectModule
  ],
  exports: [ MatFormFieldModule, MatInputModule ],

  providers: [],
  bootstrap: [
    AppComponent
  ],
})
export class AppModule { }
