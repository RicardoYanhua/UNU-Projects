import { Component, AfterViewInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ElementRef } from '@angular/core';
import { ViewChild } from '@angular/core';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-dashboard-layout',
  imports: [
    RouterOutlet,
    CommonModule,
    RouterModule
  ],
  templateUrl: './app-session.html',
  styleUrl: './app-session.scss',
})
export class SessionComponent implements AfterViewInit {
  

  @ViewChild('scrollContainer', { static: false }) scrollContainer!: ElementRef;

  ocultar = false;
  private scrollAnterior = 0;
  private escucha: any;
  ngAfterViewInit() {


    this.escucha = () => {
      const scrollActual = this.scrollContainer.nativeElement.scrollTop;
      this.ocultar = (scrollActual > this.scrollAnterior) && (scrollActual > 70);
      this.scrollAnterior = scrollActual;
    };
    this.scrollContainer.nativeElement.addEventListener('scroll', this.escucha);



  }
  ngOnDestroy() {
    this.scrollContainer?.nativeElement.removeEventListener('scroll', this.escucha);
  }
  isHidden(): boolean {
    return this.ocultar;
  }

}
