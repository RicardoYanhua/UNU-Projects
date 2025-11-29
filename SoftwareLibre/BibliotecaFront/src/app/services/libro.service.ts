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

  ObtenerLibros(): Observable<LibroResponse> {
    return this.http.get<LibroResponse>(this.api);
  }

  ObtenerLibroPorId(id: number): Observable<LibroResponse> {
    return this.http.get<LibroResponse>(`${this.api}/${id}`);
  }

  CrearLibro(libro: any): Observable<LibroResponse> {
    return this.http.post<LibroResponse>(this.api, libro);
  }
  ActualizarLibro(id: any, libro: any): Observable<LibroResponse> {
    return this.http.put<LibroResponse>(`${this.api}/${id}`, libro);
  } 
  EliminarLibro(id: number): Observable<LibroResponse> {
    return this.http.delete<LibroResponse>(`${this.api}/${id}`);
  } 

}
