import { Routes } from '@angular/router';

export const routes: Routes = [

     {
    path: '',
    loadChildren: () => import('./layouts/lobby/app-pages-router').then(m => m.pagesRoutes)
  },
  {
    path: 'account',
    loadChildren: () => import('./layouts/auth/app-session-router').then(m => m.sessionsRoutes)
  },

];
