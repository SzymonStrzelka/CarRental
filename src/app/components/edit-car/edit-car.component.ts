
import { OnInit } from "@angular/core";
import { Component } from "@angular/core";
import { Car } from "src/app/models/car";
import { CarService } from "src/app/services/car.service";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";

@Component({
  selector: 'app-edit-car',
  templateUrl: './edit-car.component.html',
  styleUrls: ['./edit-car.component.css']
})
export class EditCarComponent implements OnInit {

    car: Car;

    constructor(private carService: CarService,
              private route: ActivatedRoute,
              private router: Router) {}
    
    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id');

        if (id == null) {
        this.car = {id: null, brand: '', model: '', hp: null};
        } else {
        this.carService.findCar(+id)
            .subscribe(car => this.car = car);
        }        
    }

    save(){
        this.carService.saveCar(this.car).subscribe(() => this.router.navigateByUrl('cars'));
    }


}