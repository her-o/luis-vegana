import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-carousel',
  templateUrl: './category-carousel.component.html',
  styleUrls: ['./category-carousel.component.css']
})
export class CategoryCarouselComponent implements OnInit {

  recipes:any = [
    {title: "Not Burger", image: '../../assets/img/burger.jpg', description: "A delicious burger made without meat!", duration: "30m"},
    {title: "Vegan Pizza", image: '../../assets/img/pizza.jpg', description: "Try this amazing Pizza and tell me what you think!", duration: "60m"},
    {title: "Vegan Gyozas", image: '../../assets/img/momos.jpg', description: "Are you a fan of asian food? If that's so you gotta taste the gyozas...", duration: "80m"},
    {title: "Vegan Tacos", image: '../../assets/img/tacos.jpg', description: "If you are into Mexican, I got you covered! Cook these amazing Tacos!", duration: "40m"},
    {title: "Vegan Ramen", image: '../../assets/img/ramen.jpg', description: "An excelent choice for the cold days. You cannot go wrong with this Ramen!", duration: "60m"}
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
