import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

/**
 * 🔐 Interceptor HTTP que agrega el token JWT a las solicitudes salientes si está disponible.
 */
@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  /**
   * Método que intercepta todas las solicitudes HTTP salientes.
   * 
   * @param req - La solicitud HTTP original.
   * @param next - El siguiente manejador de la cadena (envía la solicitud).
   * @returns Un Observable del evento HTTP, posiblemente modificado.
   */
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    // 🔎 Recupera el token JWT almacenado en localStorage (si existe)
    const token = localStorage.getItem('jwt');

    // ✅ Si hay token, clona la solicitud original y agrega el encabezado Authorization
    if (token) {
      const authReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}` // ⬅️ Encabezado estándar para autenticación JWT
        }
      });

      // 🔄 Continúa el flujo de la solicitud con la versión modificada
      return next.handle(authReq);
    }

    // ❌ Si no hay token, se envía la solicitud original sin modificar
    return next.handle(req);
  }
}
