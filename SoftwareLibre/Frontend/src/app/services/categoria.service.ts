import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { CategoriaResponse } from '../models/categoria.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private api = `${environment.apiUrl}/categorias`;
  constructor(private http: HttpClient) { }

  Listar(): Observable<CategoriaResponse> {
    return this.http.get<CategoriaResponse>(this.api);
  }

  Crear(DATA_JSON: any): Observable<CategoriaResponse> {
    return this.http.post<CategoriaResponse>(this.api, DATA_JSON);
  }

  Actualizar(id: any, DATA_JSON: any): Observable<CategoriaResponse> {
    return this.http.put<CategoriaResponse>(`${this.api}/${id}`, DATA_JSON);
  }

  Eliminar(id: number): Observable<CategoriaResponse> {
    return this.http.delete<CategoriaResponse>(`${this.api}/${id}`);
  }

  ObtenerPorId(id: number): Observable<CategoriaResponse> {
    return this.http.get<CategoriaResponse>(`${this.api}/${id}`);
  }

}
