import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../Auth/AuthService';

/**
 * 🚫 Guard que impide el acceso a rutas como /login o /register si el usuario ya está autenticado.
 */
@Injectable({
  providedIn: 'root'
})
export class NoAuthGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  /**
   * ✅ Método que decide si se permite o no la activación de la ruta.
   * 
   * - Si el usuario ya está logueado, lo redirige a la página principal y niega el acceso.
   * - Si no está logueado, permite el acceso a la ruta protegida por este guard.
   * 
   * @returns `true` si el usuario NO está autenticado (puede acceder), `false` si ya lo está.
   */
  canActivate(): boolean {
    if (this.authService.estaLogueado()) {
      // 🔁 Usuario autenticado, redirigir a la ruta raíz u otra ruta protegida por roles
      this.router.navigateByUrl('');
      return false; // ❌ No se permite el acceso a la ruta (ej. /login)
    }

    // ✅ Usuario no autenticado, permitir acceso
    return true;
  }
}
