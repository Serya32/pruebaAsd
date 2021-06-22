import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearActivoFijoComponent } from './components/crear-activo-fijo/crear-activo-fijo.component';
import { ListaActivoFijoComponent } from './components/lista-activo-fijo/lista-activo-fijo.component';

const routes: Routes = [
  { path: 'listarActivo', component: ListaActivoFijoComponent },
  { path: 'crear', component: CrearActivoFijoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
