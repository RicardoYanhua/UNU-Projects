import { Routes } from '@angular/router';
import { Pedidos } from './components/pedidos/pedidos';

export const routes: Routes = [

    {
        path: '' ,  redirectTo: '/pedidos', pathMatch: 'full'
    },
    {
        path: 'pedidos', component: Pedidos
    },
    {
        path: '**', redirectTo: '/pedidos'
    }

];
