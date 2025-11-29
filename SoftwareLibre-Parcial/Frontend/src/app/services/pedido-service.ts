import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PedidoResponse } from '../models/PedidosInterface';

@Injectable({
  providedIn: 'root',
})
export class PedidoService {
  
  private api = `${environment.apiUrl}/pedidos`;
  constructor(private http: HttpClient){}

  Listar(): Observable<PedidoResponse>{
    return this.http.get<PedidoResponse>(this.api);
  }
  Crear(Pedido: any): Observable<PedidoResponse>{
    return this.http.post<PedidoResponse>(this.api, Pedido);
  }
  Actualizar(codigo: number, Pedido: any): Observable<PedidoResponse>{
    return this.http.put<PedidoResponse>(`${this.api}/${codigo}`, Pedido);
  }
  Eliminar(codigo: number): Observable<PedidoResponse>{
    return this.http.delete<PedidoResponse>(`${this.api}/${codigo}`);
  }
  ListaPorCliente(codigo: number): Observable<PedidoResponse>{
    return this.http.get<PedidoResponse>(`${this.api}/cliente/${codigo}`);
  }

  ListaPorRestaurante(codigo: number): Observable<PedidoResponse>{
    return this.http.get<PedidoResponse>(`${this.api}/restaurante/${codigo}`);
  }
   ListaPorCatPlato(codigo: number): Observable<PedidoResponse>{
    return this.http.get<PedidoResponse>(`${this.api}/cplato/${codigo}`);
  }

}
