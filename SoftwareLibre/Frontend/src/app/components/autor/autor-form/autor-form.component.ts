import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { AutorService } from '../../../services/autor.service';

@Component({
  selector: 'app-autor-form',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './autor-form.component.html',
  styleUrl: './autor-form.component.css'
})
export class AutorFormComponent implements OnInit {


  EntityForm: FormGroup;

  isEditMode: boolean = false;
  Entity_ID: number | null = null;

  error: string = '';
  successMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private service: AutorService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.EntityForm = this.fb.group(
      {
        nombres: ['', Validators.required],
        apellidos: ['', Validators.required],
      }
    );

  }

  CargarPorId(id: number) {
    this.service.ObtenerPorId(id).subscribe(
      {
        next: (response) => {
          if (response.success && response.data) {
            this.EntityForm.patchValue(response.data!);
          }
        },
        error: (err) => {
          this.error = "Error al cargar el registro."
          console.log(this.error);
        }
      }
    );
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.Entity_ID = + params['id'];
        this.CargarPorId(this.Entity_ID);
      } else {
        this.isEditMode = false;
      }
    });
  }

  onSubmit() {
    if (this.isEditMode) {


      if (confirm('¿Guardar los cambios?')) {
        this.service.Actualizar(this.Entity_ID, this.EntityForm.value).subscribe({
          next: (response) => {
            if (response.success) {
              this.router.navigate(['/autores']);
            }
          },
          error: (err) => {
          }
        });
      }


    } else {
      this.service.Crear(this.EntityForm.value).subscribe({
        next: (response) => {
          if (response.success) {
            this.router.navigate(['/autores']);
          }
        },
        error: (err) => {
        }
      });
    }
  }
}