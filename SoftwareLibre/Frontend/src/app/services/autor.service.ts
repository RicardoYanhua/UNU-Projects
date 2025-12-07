import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AutorResponse } from '../models/autor.interface';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  private api = `${environment.apiUrl}/autores`;
  constructor(private http: HttpClient) { }

  Listar(): Observable<AutorResponse> {
    return this.http.get<AutorResponse>(this.api);
  }

  Crear(DATA_JSON: any): Observable<AutorResponse> {
    return this.http.post<AutorResponse>(this.api, DATA_JSON);
  }
  
  Actualizar(id: any, DATA_JSON: any): Observable<AutorResponse> {
    return this.http.put<AutorResponse>(`${this.api}/${id}`, DATA_JSON);
  } 

  Eliminar(id: number): Observable<AutorResponse> {
    return this.http.delete<AutorResponse>(`${this.api}/${id}`);
  } 

  ObtenerPorId(id: number): Observable<AutorResponse> {
    return this.http.get<AutorResponse>(`${this.api}/${id}`);
  }

}
