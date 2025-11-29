import { AfterViewInit, Component, ElementRef, ViewChild, ViewChildren, QueryList, Input, NgZone } from '@angular/core';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-page-inicio',
  imports: [
    CommonModule
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home implements AfterViewInit {

  constructor(private el: ElementRef) { }

  @ViewChild('animImage') animImageRef!: ElementRef<HTMLImageElement>;
  @ViewChild('main') main!: ElementRef<HTMLImageElement>;

  ngAfterViewInit(): void {

}

    /*
        animate('.square', {
          x: '15rem',
          rotate: '1turn',
          duration: 2000,
          alternate: true,
          loop: true,
          ease: 'inOutQuad',
          autoplay: onScroll({
            container: '.scroll-container'
          })
        });
    */




    /*
        gsap.to(this.box.nativeElement, {
          y: -20,
          duration: 1.2,
          repeat: -1,       // repetir infinitamente
          yoyo: true,       // vuelve al estado original
          ease: 'power1.inOut'
        });
    
    
    
    
    */
    /*
     const elementos: NodeListOf<HTMLElement> = this.el.nativeElement.querySelectorAll('.animar-gsap');
     const observer = new IntersectionObserver(entries => {
       entries.forEach(entry => {
         if (entry.isIntersecting) {
           gsap.fromTo(entry.target,
             { opacity: 0, y: 80 },
             { opacity: 1, y: 0, duration: 1, ease: 'power2.out' }
           );
           //observer.unobserve(entry.target);
         }
       });
     }, {
       threshold: 0.4
     });
     elementos.forEach(el => observer.observe(el));*/


    /*
        this.scrollService.getScroller$().subscribe(scroller => {
          if (!scroller) { return; }
          const tl = gsap.timeline({
            ease: 'power2.out',
            scrollTrigger: {
              trigger: this.MainSection.nativeElement,
              scroller,
              scrub:true,
             toggleActions: "play none none none",
              start: 'top 0%',
              end: 'bottom 100% ',
             // markers: true
            },
            duration:1000
          });
    
          tl.to("#hero-key", { scale: 2 },0)
            .to("#hero-key-logo", { opacity: 0 }, "<")
            .to("#hero-footer", { opacity: 0 }, "<")
            .to("#hero-play-button", { opacity: 0 }, "<")
            .to("#hero-dest",{scale:2, duration:0.005})
            .to("#logo-mask", {
              maskSize: "clamp(20vh, 25%, 30vh)"
            }, 1);
        }
        );
    
    
    
    */





  






}
