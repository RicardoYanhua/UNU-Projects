import { Component, ElementRef, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuLinks } from '../links/menu-links';

@Component({
  selector: 'app-header-sidebar',
  templateUrl: './sidebar.html',
  styleUrl: './sidebar.scss',
  imports:[CommonModule, MenuLinks]
})
export class HeaderSidebar {
  menuAbierto = false;

  abrirPanel() {
    this.menuAbierto = true;
  }

  cerrarPanel() {
    this.menuAbierto = false;
  }
}
