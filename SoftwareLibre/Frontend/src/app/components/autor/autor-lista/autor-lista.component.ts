import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Autor } from '../../../models/autor.interface';
import { AutorService } from '../../../services/autor.service';

@Component({
  selector: 'app-autor-lista',
  
  imports: [CommonModule, RouterLink],
  templateUrl: './autor-lista.component.html',
  styleUrl: './autor-lista.component.css'
})
export class AutorListaComponent implements OnInit {

  ARRAY_LIST_DATA: Autor[] = [];
  ENTITY_DATA!: Autor;

  constructor(private service: AutorService) { }

  ngOnInit(): void {
    this.Listar();
  }

  Listar() {
    this.service.Listar().subscribe(
      {
        next: (response) => {
          if (response.success && Array.isArray(response.data)) {
            this.ARRAY_LIST_DATA = response.data;
          }
        },
        error: (err) => {
        }
      }
    );
  }


  Eliminar(id: any) {
    if (confirm('¿Estás seguro de eliminar este registro?')) {
      this.service.Eliminar (id).subscribe({
        next: (response) => {
          if (response.success) {
            this.Listar();
          }
        },
        error: (err) => {
        }
      });
    }
  }


}
