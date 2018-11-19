import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Car } from "src/app/models/car";
import { CarService } from "src/app/services/car.service"
import { CarRental } from "src/app/models/car-rental";

@Component({
  selector: 'app-list-rentals',
  templateUrl: './list-rentals.component.html',
  styleUrls: ['./list-rentals.component.css']
})
export class ListRentalsComponent implements OnInit {
    rentals: Observable<CarRental[]>

    constructor(private carService: CarService) {}
     
    ngOnInit(): void {
            this.rentals = this.carService.findAllCarRentals();
    }

    remove(rental: CarRental){
        this.carService.removeCarRental(rental.id).subscribe(() => this.ngOnInit());
    }
}