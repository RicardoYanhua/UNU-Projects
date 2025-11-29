import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


const STORAGE_KEY = 'enlaceActivo';

@Injectable({
    providedIn: 'root'
})
export class MenuLinkService {
    private enlaceActivoSubject = new BehaviorSubject<string | null>(null);

    enlaceActivo$;

    constructor() {
        const enlaceGuardado = sessionStorage.getItem(STORAGE_KEY);
        this.enlaceActivoSubject = new BehaviorSubject<string | null>(enlaceGuardado);
        this.enlaceActivo$ = this.enlaceActivoSubject.asObservable();
    }

    setActivo(href: string) {
        sessionStorage.setItem(STORAGE_KEY, href);
        this.enlaceActivoSubject.next(href);
    }

    getActivo(): string | null {
        return this.enlaceActivoSubject.getValue();
    }
}