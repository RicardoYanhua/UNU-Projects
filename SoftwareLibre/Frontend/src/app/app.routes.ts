import { Routes } from '@angular/router';
import { EntityListComponent } from './components/entity/entity-list/entity-list.component';
import { EntityFormComponent } from './components/entity/entity-form/entity-form.component';
import { LibroListaComponent } from './components/libro/libro-lista/libro-lista.component';
import { LibroFormComponent } from './components/libro/libro-form/libro-form.component';
import { AutorListaComponent } from './components/autor/autor-lista/autor-lista.component';
import { AutorFormComponent } from './components/autor/autor-form/autor-form.component';
import { CategoriaListarComponent } from './components/categoria/categoria-listar/categoria-listar.component';
import { CategoriaFormComponent } from './components/categoria/categoria-form/categoria-form.component';

export const routes: Routes = [

    {
        path: '', redirectTo: '/entity', pathMatch: 'full'
    },

    { path: 'entity', component: EntityListComponent },
    { path: 'entity/crear', component: EntityFormComponent },
    { path: 'entity/actualizar/:id', component: EntityFormComponent },

    { path: 'libros', component: LibroListaComponent },
    { path: 'libros/crear', component: LibroFormComponent },
    { path: 'libros/actualizar/:id', component: LibroFormComponent },

    { path: 'autores', component: AutorListaComponent },
    { path: 'autores/crear', component: AutorFormComponent },
    { path: 'autores/actualizar/:id', component: AutorFormComponent },

    { path: 'categorias', component: CategoriaListarComponent },
    { path: 'categorias/crear', component: CategoriaFormComponent },
    { path: 'categorias/actualizar/:id', component: CategoriaFormComponent },

    {
        path: '**', redirectTo: '/entity'
    }
];
