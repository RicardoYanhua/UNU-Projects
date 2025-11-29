import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Route, Router, RouterLink } from "@angular/router";
import { LibroService } from '../../services/libro.service';

@Component({
  selector: 'app-libro-form',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './libro-form.component.html',
  styleUrl: './libro-form.component.css'
})
export class LibroFormComponent implements OnInit {


  libroForm: FormGroup;

  isEditMode: boolean = false;
  libroId: number | null = null;

  error: string = '';
  successMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private libroService: LibroService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.libroForm = this.fb.group(
      {
        titulo: ['', Validators.required],
        autor: ['', Validators.required],
        isbn: ['', Validators.required],
        editorial: ['', Validators.required]
      }
    );

  }

  cargarLibro(id: number) {
    this.libroService.ObtenerLibroPorId(id).subscribe(
      {
        next: (response) => {
          if (response.success && [Array.isArray(response.data)]) {
            this.libroForm.patchValue(response.data!);
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
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.libroId = + params['id'];
        this.cargarLibro(this.libroId);
      }
    });
  }

  onSubmit() {
    if (confirm('¿Guardar los cambios?')) {
      this.libroService.ActualizarLibro(this.libroId, this.libroForm.value).subscribe({
        next: (response) => {
          if (response.success) {
            this.router.navigate(['/libros']);
          }
        },
        error: (err) => {
        }
      });
    }
  }



}
