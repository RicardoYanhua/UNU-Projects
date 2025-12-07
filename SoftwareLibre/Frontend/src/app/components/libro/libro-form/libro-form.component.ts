import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Route, Router, RouterLink } from "@angular/router";
import { LibroService } from '../../../services/libro.service';
import { AutorService } from '../../../services/autor.service';
import { Autor } from '../../../models/autor.interface';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { Categoria } from '../../../models/categoria.interface';
import { CategoriaService } from '../../../services/categoria.service';

@Component({
  selector: 'app-libro-form',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterLink,
    MatFormFieldModule,
    MatSelectModule
  ],
  templateUrl: './libro-form.component.html',
  styleUrl: './libro-form.component.css'
})
export class LibroFormComponent implements OnInit {


  EntityForm: FormGroup;

  CBOX_AUTORES: Autor[] = [];
  CBOX_CATEGORIAS: Categoria[] = [];

  isEditMode: boolean = false;
  Entity_ID: number | null = null;

  error: string = '';
  successMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private libroService: LibroService,
    private autorService: AutorService,
    private categoriaService: CategoriaService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.EntityForm = this.fb.group(
      {
        titulo: ['', Validators.required],
        idAutor: [null, Validators.required],
        isbn: ['', Validators.required],
        editorial: ['', Validators.required],
        anioPublicacion: ['', Validators.required],
        idCategoria: [null, Validators.required]
      }
    );

  }

  cargarLibro(id: number) {
    this.libroService.ObtenerPorId(id).subscribe(
      {
        next: (response) => {
          if (response.success && [Array.isArray(response.data)]) {
            this.EntityForm.patchValue(response.data!);
          }
        },
        error: (err) => {
          this.error = "Error al cargar el libro."
          console.log(this.error);
        },


      }
    );
  }

  ngOnInit(): void {

    this.autorService.Listar().subscribe({
      next: (response) => {
        if (response.success && Array.isArray(response.data)) {
          this.CBOX_AUTORES = response.data;
        }
      },
      error: (err) => {
        
      }
    });

    this.categoriaService.Listar().subscribe({
      next: (response) => {
        if (response.success && Array.isArray(response.data)) {
          this.CBOX_CATEGORIAS = response.data;
        }
      },
      error: (err) => {
        
      }
    });

    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.Entity_ID = + params['id'];
        this.cargarLibro(this.Entity_ID);
      } else {
        this.isEditMode = false;
      }
    });
  }

  onSubmit() {
    if (this.isEditMode) {


      if (confirm('¿Guardar los cambios?')) {
        this.libroService.Actualizar(this.Entity_ID, this.EntityForm.value).subscribe({
          next: (response) => {
            if (response.success) {
              this.router.navigate(['/libros']);
            }
          },
          error: (err) => {
          }
        });
      }


    } else {

      console.log(this.EntityForm.value);
      this.libroService.Crear(this.EntityForm.value).subscribe({
        next: (response) => {
          if (response.success) {
            this.router.navigate(['/libros']);
          }
        },
        error: (err) => {
          console.warn(err.mensaje);
        }
      });
    }
  }



}
