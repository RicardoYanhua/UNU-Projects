import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthService } from './AuthService';

/**
 * 🔐 Guard de autorización por rol.
 * 
 * Permite acceder a una ruta solo si el usuario está autenticado
 * y tiene al menos uno de los roles requeridos definidos en la ruta.
 */
@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  /**
   * Método que decide si se permite o no el acceso a una ruta basada en los roles del usuario.
   * 
   * @param route - La ruta actual que intenta activarse, usada para obtener los roles requeridos.
   * @returns `true` si el usuario tiene permisos, `false` si no.
   */
  canActivate(route: ActivatedRouteSnapshot): boolean {

    // ❌ Si el usuario no está logueado o el token expiró
    if (!this.authService.estaLogueado()) {
      this.router.navigate(['/login']);
      return false;
    }

    // 🔍 Obtenemos los datos del usuario desde el JWT
    const usuario = this.authService.obtenerUsuario();

    // ❌ Si el token es inválido o no contiene roles
    if (!usuario || !usuario.roles) {
      this.router.navigate(['/login']);
      return false;
    }

    // 🔐 Roles del usuario separados por espacio: "ROLE_USER ROLE_ADMIN"
    const userRoles = usuario.roles.split(' ');

    // 📋 Roles requeridos para acceder a esta ruta (configurados en la ruta con `data: { roles: [...] }`)
    const requiredRoles = route.data['roles'] as string[];

    // ✅ Verificamos si el usuario tiene al menos uno de los roles requeridos
    const tieneAcceso = requiredRoles.some(role => userRoles.includes(role));

    if (!tieneAcceso) {
      // 🚫 Usuario autenticado pero sin los permisos necesarios
      this.router.navigate(['/forbidden']); // Puede ser otra ruta como /403 o /home
      return false;
    }

    // ✅ Usuario con rol autorizado, se permite el acceso
    return true;
  }
}
