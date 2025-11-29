import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header-cart',
  templateUrl: './cart.html',
  styleUrl: './cart.scss',
  imports:[CommonModule]
})
export class HeaderCart {
  menuAbierto = false;

  abrirPanel() {
    this.menuAbierto = true;
  }

  cerrarPanel() {
    this.menuAbierto = false;
  }
}
