import { Routes } from '@angular/router';
import { LibroListaComponent } from './components/libro-lista/libro-lista.component';
import { LibroFormComponent } from './components/libro-form/libro-form.component';

export const routes: Routes = [
    {
        path: '', redirectTo: '/libros', pathMatch: 'full'
    },

    { path: 'libros', component: LibroListaComponent },
    { path: 'libros/nuevo', component: LibroFormComponent },
    { path: 'libros/editar/:id', component: LibroFormComponent },
    { path: 'categorias', component: LibroListaComponent },

    {
        path: '**', redirectTo: '/libros'
    }
];
