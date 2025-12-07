import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Entity } from '../../../models/entity.interface';
import { EntityService } from '../../../services/entity.service';

@Component({
  selector: 'app-entity-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './entity-list.component.html',
  styleUrl: './entity-list.component.css'
})
export class EntityListComponent implements OnInit {

  ARRAY_LIST_DATA: Entity[] = [];
  ENTITY_DATA!: Entity;

  constructor(private service: EntityService) { }

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

