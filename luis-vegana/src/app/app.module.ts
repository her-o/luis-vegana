import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroComponent } from './components/sections/hero/hero.component';
import { RecipesComponent } from './components/sections/recipes/recipes.component';
import { CarouselComponent } from './components/sections/recipes/widgets/carousel/carousel.component';
import { HeaderComponent } from './components/header/header.component';
import { AboutComponent } from './components/sections/about/about.component';
import { ContactComponent } from './components/sections/contact/contact.component';
import { HomeComponent } from './components/pages/home-page/home/home.component';

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
