import { Component } from '@angular/core';
import { RouterModule, RouterLink } from '@angular/router';


@Component({
  selector: 'app-root',
  imports: [
    RouterModule,
    RouterLink
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BibliotecaFront';
}
