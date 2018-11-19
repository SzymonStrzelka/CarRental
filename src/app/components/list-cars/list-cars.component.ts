import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Car } from "src/app/models/car";
import {CarService} from "src/app/services/car.service"

@Component({
  selector: 'app-list-cars',
  templateUrl: './list-cars.component.html',
  styleUrls: ['./list-cars.component.css']
})
export class ListCarsComponent implements OnInit {
    cars: Observable<Car[]>

    constructor(private carService: CarService) {}
     
    ngOnInit(): void {
            this.cars = this.carService.findAllCars();
    }

    remove(car: Car){
        this.carService.removeCar(car.id).subscribe(() => this.ngOnInit());
    }
}