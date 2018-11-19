import { Car } from "src/app/models/car";

export class CarRental {
    id: number;
    startDate: string;
    endDate: string;
    price: number;
    car: Car;
    carId: number;
}