import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app/app.component';
import { CarService } from "src/app/services/car.service";
import { ListCarsComponent } from "src/app/components/list-cars/list-cars.component";
import { EditCarComponent } from "src/app/components/edit-car/edit-car.component";
import { ListRentalsComponent } from "src/app/components/list-rentals/list-rentals.component";
import { EditCarRentalComponent } from "src/app/components/edit-rental/edit-rental.component";

@NgModule({
  declarations: [
    AppComponent,
    ListCarsComponent,
    EditCarComponent,
    EditCarRentalComponent,
    ListRentalsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
