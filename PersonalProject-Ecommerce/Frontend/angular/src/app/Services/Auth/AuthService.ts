import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../Models/LoginRequestModel';
import { RegisterUserRequest } from '../Models/RegisterUserRequestModel';
import { RegisterGoogleRequest } from '../Models/RegisterGoogleRequestModel';
import { Observable, throwError, BehaviorSubject, tap, map, catchError } from 'rxjs';
import { environment } from '../Env/environment';
import { jwtDecode } from 'jwt-decode';
import { JwtPayload } from '../Models/JwtPayloadModel';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  /** 🔐 Emite `true` si el usuario está logueado, `false` si no */
  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  /** 🧾 Emite el token JWT actual (como string) */
  currentUserData: BehaviorSubject<string> = new BehaviorSubject<string>("");

  constructor(private http: HttpClient) {
    const token = localStorage.getItem("jwt");
    this.currentUserLoginOn.next(!!token); // simplificado
    this.currentUserData.next(token || "");
  }

  /** 📦 Registro manual de usuario */
  register(data: RegisterUserRequest): Observable<any> {
    return this.http.post<any>(`${environment.urlHost}api/auth/registeruser`, data)
      .pipe(catchError(this.handleError));
  }

  /** 🔐 Registro de usuario mediante Google */
  registerGoogle(data: RegisterGoogleRequest): Observable<any> {
    return this.http.post<any>(`${environment.urlHost}api/auth/registergoogle`, data)
      .pipe(catchError(this.handleError));
  }

  /** 🔑 Login tradicional con email y contraseña */
  login(credentials: LoginRequest): Observable<string> {
    return this.http.post<any>(`${environment.urlHost}api/auth/login`, credentials).pipe(
      tap(res => this.setSession(res.jwt)),        // Guarda el token
      map(res => res.jwt),                         // Devuelve solo el token
      catchError(this.handleError)
    );
  }

  /** 🔐 Login con token de Google */
  loginConGoogle(idToken: string): Observable<string> {
    return this.http.post<any>(`${environment.urlHost}api/auth/google`, { idToken }).pipe(
      tap(res => this.setSession(res.jwt)),
      map(res => res.jwt),
      catchError(this.handleError)
    );
  }

  /** 🚪 Cerrar sesión y limpiar estado */
  logout(): void {
    this.http.post(`${environment.urlHost}/logout`, {}, { withCredentials: true }).subscribe();
    localStorage.removeItem("jwt");
    this.currentUserLoginOn.next(false);
    this.currentUserData.next("");
  }

  /** 🧠 Guarda el token en localStorage y actualiza estado */
  private setSession(jwt: string): void {
    localStorage.setItem("jwt", jwt);
    this.currentUserData.next(jwt);
    this.currentUserLoginOn.next(true);
  }

  /** ✅ Verifica si el usuario tiene al menos uno de los roles requeridos */
  tieneAlgunRol(rolesRequeridos: string[]): boolean {
    const usuario = this.obtenerUsuario();
    if (!usuario?.roles) return false;

    const rolesUsuario = usuario.roles.split(' ');
    return rolesRequeridos.some(rol => rolesUsuario.includes(rol));
  }

  /** 📄 Devuelve el objeto decodificado del JWT o `null` si es inválido */
  obtenerUsuario(): JwtPayload | null {
    const token = localStorage.getItem("jwt");
    if (!token) return null;

    try {
      return jwtDecode<JwtPayload>(token);
    } catch (e) {
      return null;
    }
  }

  /** 🔒 Verifica si el usuario está logueado y su token no ha expirado */
  estaLogueado(): boolean {
    const token = localStorage.getItem("jwt");
    if (!token) return false;

    try {
      const decoded = jwtDecode<JwtPayload>(token);
      const ahora = Math.floor(Date.now() / 1000);
      return decoded.exp > ahora;
    } catch {
      return false;
    }
  }

  /** ⚠️ Manejo centralizado de errores */
  private handleError(error: HttpErrorResponse) {
    if (error.status === 404 && error.error?.error === 'USER_NOT_FOUND') {
      // Usuario no encontrado al intentar login con Google
      return throwError(() => ({
        type: 'USER_NOT_FOUND',
        email: error.error.email,
        picture: error.error.picture
      }));
    }

    if (error.status === 400 && typeof error.error === 'object') {
      // Error de validación de datos
      return throwError(() => ({
        type: 'VALIDATOR_ERROR',
        errors: error.error
      }));
    }

    // Error genérico
    return throwError(() => new Error('Algo falló. Por favor intente nuevamente.'));
  }
}

