import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListCarsComponent } from "src/app/components/list-cars/list-cars.component";
import { EditCarComponent } from "src/app/components/edit-car/edit-car.component";
import { ListRentalsComponent } from "src/app/components/list-rentals/list-rentals.component";
import { EditCarRentalComponent } from "src/app/components/edit-rental/edit-rental.component";

const routes: Routes = [
  {path:'cars', component: ListCarsComponent},
  {path:'cars/new', component: EditCarComponent},
  {path:'cars/:id/edit', component: EditCarComponent},
  {path:'rentals/:id/edit', component: EditCarRentalComponent},
  {path:'rentals/new', component: EditCarRentalComponent},
  {path:'rentals', component: ListRentalsComponent},  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
