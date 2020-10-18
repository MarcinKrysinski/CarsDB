package pl.krysinski.db.service;

import pl.krysinski.db.model.Car;

import java.util.List;

public interface CarService {
    
    List<Car> getCarList();
    List<Car> findCarsFromTheRange(int lowDateProduction, int maxDateProduction);
    void addCar(Car newCar);
    void deleteCar(long id);
}
