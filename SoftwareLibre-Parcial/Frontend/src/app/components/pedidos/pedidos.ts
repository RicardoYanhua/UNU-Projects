import { Component, OnInit } from '@angular/core';
import { Pedido } from '../../models/PedidosInterface';
import { PedidoService } from '../../services/pedido-service';
import { JsonPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-pedidos',
  imports: [JsonPipe,CommonModule],
  templateUrl: './pedidos.html',
  styleUrl: './pedidos.css',
})

export class Pedidos  implements OnInit{

  pedidos: Pedido[] = [];
  pedido!: Pedido;
pedidoscliente:Pedido[] = [];
pedidosRestaurante:Pedido[] = [];
pedidosCatPlato:Pedido[] = [];
  constructor(
    private PedidoService: PedidoService
  ){

  }
  ngOnInit(): void {
      this.ListarPedidos();
      this.ListarPedidosPorCliente(1);
      this.ListarPedidosPorRestaurante(2);
      this.ListarPedidosPorCatPlato(2);
  }

  ListarPedidos(){
    this.PedidoService.Listar().subscribe(
      {
        next: (response)=> {
          if(response.success && Array.isArray(response.data)){
            this.pedidos = response.data;
            

          }
        },
        error: (err)=>{
          console.error("Error al cargar la lista de pedidos.");
        }
      }
    )
  }
   ListarPedidosPorCliente(codigo:number){
    this.PedidoService.ListaPorCliente(codigo).subscribe(
      {
        next: (response)=> {
          if(response.success  && Array.isArray(response.data)){
            this.pedidoscliente = response.data;
            
          }
        },
        error: (err)=>{
          console.error("Error al cargar la lista de pedidos por cliente.");
        }
      }
    )
  }

  ListarPedidosPorRestaurante(codigo:number){
    this.PedidoService.ListaPorRestaurante(codigo).subscribe(
      {
        next: (response)=> {
          if(response.success  && Array.isArray(response.data)){
            this.pedidosRestaurante = response.data;
            
          }
        },
        error: (err)=>{
          console.error("Error al cargar la lista de pedidos por restaurante.");
        }
      }
    )
  }
  ListarPedidosPorCatPlato(codigo:number){
    this.PedidoService.ListaPorCatPlato(codigo).subscribe(
      {
        next: (response)=> {
          if(response.success  && Array.isArray(response.data)){
            this.pedidosCatPlato = response.data;
            
          }
        },
        error: (err)=>{
          console.error("Error al cargar la lista de pedidos por restaurante.");
        }
      }
    )
  }

}
