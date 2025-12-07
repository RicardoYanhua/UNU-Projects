import { Component, OnInit } from '@angular/core';
import { Libro } from '../../../models/libro.interface';
import { LibroService } from '../../../services/libro.service';

import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-libro-lista',
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './libro-lista.component.html',
  styleUrls: ['./libro-lista.component.css']

})

export class LibroListaComponent implements OnInit {

  ARRAY_LIST_DATA: Libro[] = [];
  ENTITY_DATA!: Libro;

  constructor(private service: LibroService) { }

  ngOnInit(): void {
    this.Listar();
  }

  Listar() {
    this.service.Listar().subscribe(
      {
        next: (response) => {
          if (response.success && Array.isArray(response.data)) {
            this.ARRAY_LIST_DATA = response.data;
            console.log(this.ARRAY_LIST_DATA);
          }
        },
        error: (err) => {
        }
      }
    );
  }


  Eliminar(id: any) {
    if (confirm('¿Estás seguro de eliminar este libro?')) {
      this.service.Eliminar(id).subscribe({
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


  BuscarLibro(event: KeyboardEvent) {
  const input = event.target as HTMLInputElement;

  const texto = input.value; // ← ESTO YA NO DA ERROR

  if (!texto.trim()) {
    this.Listar();
    return;
  }

  this.service.Buscar(texto).subscribe({
    next: (response) => {
      if (response.success && Array.isArray(response.data)) {
            this.ARRAY_LIST_DATA = response.data;
            console.log(this.ARRAY_LIST_DATA);
          }
    }
  });
}

}