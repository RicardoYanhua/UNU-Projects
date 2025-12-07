import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { EntityResponse } from '../models/entity.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EntityService {

  private api = `${environment.apiUrl}/entidad-base`;
  constructor(private http: HttpClient) { }

  Listar(): Observable<EntityResponse> {
    return this.http.get<EntityResponse>(this.api);
  }

  Crear(DATA_JSON: any): Observable<EntityResponse> {
    return this.http.post<EntityResponse>(this.api, DATA_JSON);
  }
  
  Actualizar(id: any, DATA_JSON: any): Observable<EntityResponse> {
    return this.http.put<EntityResponse>(`${this.api}/${id}`, DATA_JSON);
  } 

  Eliminar(id: number): Observable<EntityResponse> {
    return this.http.delete<EntityResponse>(`${this.api}/${id}`);
  } 

  ObtenerPorId(id: number): Observable<EntityResponse> {
    return this.http.get<EntityResponse>(`${this.api}/${id}`);
  }

}
