import { Component, Input, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuLinkService } from './menu-links-service';

@Component({
  selector: 'app-menu-links',

  templateUrl: './menu-links.html',
  styleUrl: './menu-links.scss',
  imports:[CommonModule]
})
export class MenuLinks implements OnInit {
  @Input() orientation: 'horizontal' | 'vertical' = 'horizontal';

  links = [
    { texto: 'Tienda', href: '/tienda' },
    { texto: 'Productos', href: '/productos' },
    { texto: 'Novedades', href: '/novedades' }
  ];

  enlaceActivo: string | null = null;

  constructor(private menuLinkService: MenuLinkService) {}

  ngOnInit(): void {
    this.menuLinkService.enlaceActivo$.subscribe(link => {
      this.enlaceActivo = link;
    });
  }

  activate_link(item: any, event: Event) {
    if (this.enlaceActivo === item.href) {
      event.preventDefault(); // Ya está activo, no hacer nada
      return;
    }

    this.menuLinkService.setActivo(item.href);
    // No prevenir la navegación para que funcione routerLink o href si aplica
  }


}
