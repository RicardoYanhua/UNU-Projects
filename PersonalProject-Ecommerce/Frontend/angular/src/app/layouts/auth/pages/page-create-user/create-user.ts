
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../../../Services/Auth/AuthService';
import { RegisterUserRequest } from '../../../../Services/Models/RegisterUserRequestModel';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-page-create-user',
  templateUrl: './create-user.html',
  styleUrl: './create-user.scss',
  imports: [ReactiveFormsModule, CommonModule, RouterModule],
})
export class CreateUser {
  error: string = '';
  registerForm!: FormGroup;
  submitted = false;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthService) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      nombres: ['', Validators.required],
      apellidoPaterno: ['', Validators.required],
      apellidoMaterno: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }


  erroresValidacion: { [key: string]: string } = {};

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.valid) {
      const form = this.registerForm.value;
      const request: RegisterUserRequest = {
        perfilNombres: form.nombres,
        perfilPaterno: form.apellidoPaterno,
        perfilMaterno: form.apellidoMaterno,
        username: form.email,
        password: form.password
      };

      // Lógica de registro...
      this.authService.register(request).subscribe({
        next: (res) => {
          this.router.navigate(['/login']);
          this.erroresValidacion = {};
        },
        error: (err) => {
          if (err.type === 'VALIDATOR_ERROR') {
            this.erroresValidacion = err.errors;
            console.log('Errores de validación:', this.erroresValidacion);
          }
        }
      });
    } else {
      console.warn('Formulario inválido');
    }
  }

  verContrasena: boolean = false;
  alternarContrasena(): void {
    this.verContrasena = !this.verContrasena;
  }
  irALogin(): void {
    this.router.navigate(['/login']);
  }
}
