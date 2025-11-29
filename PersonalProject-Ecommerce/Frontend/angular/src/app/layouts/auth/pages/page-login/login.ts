import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../../../Services/Auth/AuthService';
import { LoginRequest } from '../../../../Services/Models/LoginRequestModel';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { environment } from '../../../../Services/Env/environment.prod';

declare const google: any;

@Component({
  selector: 'app-page-login',
  templateUrl: './login.html',
  styleUrl: './login.scss',
  imports: [ReactiveFormsModule, CommonModule, RouterModule]
})
export class Login implements OnInit {

  error: string = '';
  loginForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', Validators.required],
    });


    google.accounts.id.initialize({
      client_id: environment.googleClientId,
      callback: (response: any) => this.onCredential(response),
    });

    google.accounts.id.renderButton(
      document.getElementById('google-button'),
      {
        theme: 'outline',
        size: 'large',
        text: 'signin_with',
        locale: 'es',
        logo_alignment: 'center'
      }
    );

  }
  verContrasena: boolean = false;

  alternarContrasena(): void {
    this.verContrasena = !this.verContrasena;
  }



  onCredential(response: any) {
    const idToken = response.credential;

    this.authService.loginConGoogle(idToken).subscribe({
      next: (jwt) => {
        this.router.navigate(['']);
      },
      error: (err) => {
        if (err.type === 'USER_NOT_FOUND') {
          this.router.navigate(['/account/create-user-google'], {
            state: { 
              
              email: err.email, 
              picture: err.picture,
            }
          });
        }
      }

    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      return;
    }

    this.authService.login(this.loginForm.value as LoginRequest).subscribe({
      next: (token) => {
        this.router.navigate(['']);
      },
      error: (err) => {
        this.error = err.message || 'Error al iniciar sesión';
      }
    });
  }







}