import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home-page/home/home.component';
import { RecipesComponent } from './components/pages/recipes/recipes.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'recipes', component: RecipesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
