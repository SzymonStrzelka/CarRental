import { Car } from '../models/car';
import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http';
import { Observable } from "rxjs";
import { CarRental } from "src/app/models/car-rental";

@Injectable()
export class CarService {
    host: string =  'http://localhost:8080/CarRental-1.0-SNAPSHOT/rest/'
    carsEndpoint: string = this.host + 'cars/'
    rentalsEndpoint: string = this.host + 'car-rentals/'

    constructor(private http: HttpClient) {}

  findAllCars(): Observable<Car[]>{
      return this.http.get<Car[]>(this.carsEndpoint);
  }
  findCar(id: number): Observable<Car>{
      return this.http.get<Car>(this.carsEndpoint + id);
  }
  findCarRental(id: number): Observable<CarRental> {
      return this.http.get<CarRental>(this.rentalsEndpoint + id)
  }
  saveCar(car: Car): Observable<any>{
      if (car.id){
          return this.http.put(this.carsEndpoint + car.id, car);
      }
      else {
          return this.http.post(this.carsEndpoint, car);
      }
  }
  saveCarRental(rental: CarRental): Observable<CarRental> {
      if (rental.id){
          return this.http.put(this.rentalsEndpoint + rental.id, rental);
      }
      else {
          return this.http.post(this.rentalsEndpoint, rental);
      }
  }
  removeCar(id: number) {
      return this.http.delete(this.carsEndpoint + id);
  }

  removeCarRental(id: number) {
      return this.http.delete(this.rentalsEndpoint + id);
  }

  findAllCarRentals(): Observable<CarRental[]>{
      return this.http.get<CarRental[]>(this.rentalsEndpoint);
  }
}