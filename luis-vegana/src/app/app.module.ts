import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroComponent } from './components/sections/hero/hero.component';
import { RecipesComponent } from './components/pages/recipes/recipes.component';
import { CarouselComponent } from './components/sections/main/carousel/carousel.component';
import { HeaderComponent } from './components/header/header.component';
import { AboutComponent } from './components/sections/about/about.component';
import { ContactComponent } from './components/sections/contact/contact.component';
import { HomeComponent } from './components/pages/home-page/home/home.component';
import { MainComponent } from './components/sections/main/main.component';
import { CategoryCarouselComponent } from './components/pages/recipes/widgets/category-carousel/category-carousel.component';
import { RecipeCardComponent } from './components/pages/recipes/widgets/recipe-card/recipe-card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeroComponent,
    RecipesComponent,
    CarouselComponent,
    HeaderComponent,
    AboutComponent,
    ContactComponent,
    HomeComponent,
    MainComponent,
    CategoryCarouselComponent,
    RecipeCardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
