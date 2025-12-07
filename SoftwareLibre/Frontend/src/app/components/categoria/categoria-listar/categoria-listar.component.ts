import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Categoria } from '../../../models/categoria.interface';
import { CategoriaService } from '../../../services/categoria.service';

@Component({
  selector: 'app-categoria-listar',
imports: [CommonModule, RouterLink],
  templateUrl: './categoria-listar.component.html',
  styleUrl: './categoria-listar.component.css'
})
export class CategoriaListarComponent implements OnInit {

  ARRAY_LIST_DATA: Categoria[] = [];
  ENTITY_DATA!: Categoria;

  constructor(private service: CategoriaService) { }

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
