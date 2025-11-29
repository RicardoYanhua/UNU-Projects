import { Routes } from '@angular/router';
import { Login } from './pages/page-login/login';
import { NoAuthGuard } from '../../Services/Auth/NoAuthGuard';
import { CreateUser } from './pages/page-create-user/create-user';
import { CreateUserGoogle } from './pages/page-create-user_google/create-user-google';
import { SessionComponent } from './pages/app-session';

export const sessionsRoutes: Routes = [
  {
    path: '', component:SessionComponent,
    
    children: [
      { path: 'login', component: Login, canActivate: [NoAuthGuard] },
      { path: 'create-user', component: CreateUser, canActivate: [NoAuthGuard] },
      { path: 'create-user-google', component: CreateUserGoogle, canActivate: [NoAuthGuard] },
    ]
  }
];