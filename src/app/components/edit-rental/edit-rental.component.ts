
import { OnInit } from "@angular/core";
import { Component } from "@angular/core";
import { Car } from "src/app/models/car";
import { CarService } from "src/app/services/car.service";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { CarRental } from "src/app/models/car-rental";

@Component({
  selector: 'app-edit-rental',
  templateUrl: './edit-rental.component.html',
  styleUrls: ['./edit-rental.component.css']
})
export class EditCarRentalComponent implements OnInit {

    rental: CarRental;
    availableCars: Car[]

    constructor(private carService: CarService,
              private route: ActivatedRoute,
              private router: Router) {}
    
    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id');

        if (id == null) {
        this.rental = {id: null, startDate: '', endDate: '', price:null, car: null, carId: null};
        } else {
        this.carService.findCarRental(+id)
            .subscribe(rental => this.rental = rental);
        }        
        this.carService.findAllCars().subscribe(cars => this.availableCars = cars);
    }

    save(){
        this.rental.carId = this.rental.car.id;
        this.carService.saveCarRental(this.rental).subscribe(() => this.router.navigateByUrl('rentals'));
    }
    compareCars(c1: Car, c2: Car): boolean {
        return c1 && c2 ? c1.id === c2.id : c1 === c2;
    }

}