import { Component, OnInit } from '@angular/core';
import { Libro } from '../../models/libro.interface';
import { LibroService } from '../../services/libro.service';

import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-libro-lista',
  imports: [CommonModule, RouterLink],
  templateUrl: './libro-lista.component.html',
  styleUrls: ['./libro-lista.component.css']

})

export class LibroListaComponent implements OnInit {

  libros: Libro[] = [];
  libro!: Libro;

  constructor(private libroService: LibroService) { }

  ngOnInit(): void {
    this.CargarLibros();
  }

  CargarLibros() {
    this.libroService.ObtenerLibros().subscribe(
      {
        next: (response) => {
          if (response.success && Array.isArray(response.data)) {
            this.libros = response.data;
          }
        },
        error: (err) => {

        }
      }
    );
  }

  CargarLibroPorId(id: number) {
    this.libroService.ObtenerLibroPorId(id).subscribe(
      {
        next: (response) => {
          if (response.success && response.data) {
            this.libro = response.data as Libro;
          }
        },
        error: (err) => {
          console.error(err);
        }
      }
    );
  }

  CrearLibro(nuevoLibro: Libro) {
    this.libroService.CrearLibro(nuevoLibro).subscribe({
      next: (response) => {
        if (response.success && response.data) {
          this.libros.push(response.data.valueOf() as Libro);
        }
      },
      error: (err) => {
        console.error('Error al crear el libro:', err);
      }
    });
  }

  ActualizarLibroPorCodigo(id: number) {

    const libroActualizado: Libro = {
      titulo: 'El Principito - Edición Especial',
      autor: 'Antoine de Saint-Exupéry',
      isbn: '978-3-16-148410-0',
      editorial: 'Editorial Ejemplo Actualizada',
      idCategoria: 2
    };

    this.libroService.ActualizarLibro(id, libroActualizado).subscribe({
      next: (response) => {
        if (response.success && response.data) {
          // Actualizamos la lista local reemplazando el libro con el mismo id
          const index = this.libros.findIndex(l => l.id === id);
          if (index !== -1) {
            this.libro = response.data as Libro;
          }
          console.log('Libro actualizado:', response.data);
        }
      },
      error: (err) => {
        console.error('Error al actualizar el libro:', err);
      }
    });
  }

  EliminarLibroPorCodigo(id: any) {
    if (confirm('¿Estás seguro de eliminar este libro?')) {
      this.libroService.EliminarLibro(id).subscribe({
        next: (response) => {
          if (response.success) {
            console.log('Libro eliminado correctamente');
            this.CargarLibros();
          }
        },
        error: (err) => {
          console.error('Error al eliminar el libro:', err);
        }
      });
    }
  }


}
