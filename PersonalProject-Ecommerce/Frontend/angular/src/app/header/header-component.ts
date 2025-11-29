
import { Component, Input, OnInit } from '@angular/core';
import { MenuLinks } from './components/links/menu-links';
import { HeaderSidebar } from './components/sidebar/sidebar';
import { Router } from '@angular/router';
import { HeaderCart } from './components/cart/cart';
import { RouterModule } from '@angular/router';
import { AuthService } from '../Services/Auth/AuthService';
import { JwtPayload } from '../Services/Models/JwtPayloadModel';
import { CommonModule } from '@angular/common';
import { ButtonToggleThemeColorScheme } from "../shared/components/button-toggle-theme-color-scheme/button-toggle-theme-color-scheme";

@Component({
  selector: 'app-header-component',
  templateUrl: './header-component.html',
  styleUrl: './header-component.scss',
  imports: [
    MenuLinks,
    HeaderSidebar,
    HeaderCart,
    RouterModule,
    CommonModule,
    ButtonToggleThemeColorScheme
]
})
export class HeaderComponent implements OnInit {

  isUserLogin: boolean = false;
  usuario: JwtPayload | null = null;

  roles: string[] = [];
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.currentUserLoginOn.subscribe(
      {
        next: (userLoginOn) => {
          this.isUserLogin = userLoginOn;
          this.usuario = this.authService.obtenerUsuario();
          if (this.usuario) {
            this.roles = this.usuario.roles.split(' ');
          }

        }
      }
    )
  }

  @Input() ocultar: boolean = false;

  menuAbierto = false;
  abrirMenu() {
    this.menuAbierto = true;
  }
  cerrarMenu() {
    this.menuAbierto = false;
  }



}
