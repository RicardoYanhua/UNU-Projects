import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { LibroResponse } from '../models/libro.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private api = `${environment.apiUrl}/libros`;
  constructor(private http: HttpClient) { }

  Listar(): Observable<LibroResponse> {
    return this.http.get<LibroResponse>(this.api);
  }

  Crear(DATA_JSON: any): Observable<LibroResponse> {
    return this.http.post<LibroResponse>(this.api, DATA_JSON);
  }

  Actualizar(id: any, DATA_JSON: any): Observable<LibroResponse> {
    return this.http.put<LibroResponse>(`${this.api}/${id}`, DATA_JSON);
  }

  Eliminar(id: number): Observable<LibroResponse> {
    return this.http.delete<LibroResponse>(`${this.api}/${id}`);
  }

  ObtenerPorId(id: number): Observable<LibroResponse> {
    return this.http.get<LibroResponse>(`${this.api}/${id}`);
  }
   Buscar(texto: string): Observable<LibroResponse> {
    return this.http.get<LibroResponse>(`${this.api}/buscar/${texto}`);
  }

}
