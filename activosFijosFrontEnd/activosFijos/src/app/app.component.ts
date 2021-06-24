import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  mostrarMensaje = true;

  constructor(
    private router: Router,
    ) {}

    routes(route: string){
    if (route === 'listarActivo') {
      this.router.navigate(['listarActivo']);
    } else if (route === 'crear') {
      this.router.navigate([route]);
    }
  }
}
