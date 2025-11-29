import { Routes } from '@angular/router';
import { Home } from './pages/page-home/home';
import { PageComponent } from './app-pages';

export const pagesRoutes: Routes = [
  {
    path: '', component: PageComponent,
  
    children: [

      { path: '', component: Home,}
      
    ]
  }
];