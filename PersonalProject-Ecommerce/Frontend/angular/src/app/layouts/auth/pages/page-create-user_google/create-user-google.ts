import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../../../Services/Auth/AuthService';
import { RegisterGoogleRequest } from '../../../../Services/Models/RegisterGoogleRequestModel';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-page-create-user-google',
  templateUrl: './create-user-google.html',
  styleUrl: './create-user-google.scss',
  
  imports: [ReactiveFormsModule, CommonModule, RouterModule],
})
export class CreateUserGoogle {
  
  error: string = '';
  registerForm!: FormGroup;
  submitted = false;

  email: String = '';
  picture: String= '';
  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthService) {
      
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras.state as { email: string, picture: string };

    if (state) {
      this.email = state.email;
      this.picture = state.picture;
    }
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      nombres: ['', Validators.required],
      apellidoPaterno: ['', Validators.required],
      apellidoMaterno: ['', Validators.required],
    });
  }


  erroresValidacion: { [key: string]: string } = {};

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.valid) {
      const form = this.registerForm.value;

      const request: RegisterGoogleRequest = {
        perfilNombres: form.nombres,
        perfilPaterno: form.apellidoPaterno,
        perfilMaterno: form.apellidoMaterno,
        username: this.email.trim(),
        picture: this.picture.trim(),
      };

      // Lógica de registro...
      this.authService.registerGoogle(request).subscribe({
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

  irALogin(): void {
    this.router.navigate(['/login']);
  }
}
