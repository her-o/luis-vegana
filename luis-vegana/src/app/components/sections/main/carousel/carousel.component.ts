import { Component, Input, OnInit } from '@angular/core';
import { IcarouselItem } from './Icarousel-item.metadata';

@Component({
  selector: 'carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {

  @Input() height = 500;
  @Input() isFullScreen = false;
  
  public genericDescription:string = "Acá va una descripción genérica de la receta para que la gente haga click en el botón luego";
  recipes:IcarouselItem[] = [
    {id: 0, titleAccent: "PIZZA", title: "VEGANA", description: `${this.genericDescription}`, image: '../../assets/img/pizza.jpg', opacity: 1},
    {id: 1, titleAccent: "MOMOS", title: "VEGANOS",  description: `${this.genericDescription}`, image: '../../assets/img/momos.jpg', opacity: 0},
    {id: 2,titleAccent: "NOT", title: "BURGUER", description: `${this.genericDescription}`, image: '../../assets/img/burger.jpg', opacity: 0}
  ];

  public finalHeight: string | number = 0;
  public currentPosition = 0;

  constructor() { 
    this.finalHeight = this.isFullScreen ? '100vh' : `${this.height}px`;
    setInterval(()=> { this.setNext() }, 10000);
  }

  ngOnInit(): void {
    this.recipes.map((i, index) => {
      i.id = index;
    });
  }


  setCurrentPosition(position: number) {
    for(let recipe of this.recipes) {
      recipe.id == position ? recipe.opacity = 1: recipe.opacity = 0;
    }
    this.currentPosition = position;
  }

  setNext() {
    var position;
    this.currentPosition + 1 > this.recipes.length - 1 ? position = 0:
                                                         position = this.currentPosition + 1;
    this.setCurrentPosition(position);
  }

  setPrevious() {
    var position;
    this.currentPosition - 1 < 0 ? position = this.recipes.length - 1:
                                   position = this.currentPosition - 1;
    this.setCurrentPosition(position);
  }
}
