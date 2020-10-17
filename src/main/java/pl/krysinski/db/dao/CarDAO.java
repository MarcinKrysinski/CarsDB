package pl.krysinski.db.dao;

import pl.krysinski.db.model.Car;
import pl.krysinski.db.model.Color;


import java.util.List;

public interface CarDAO {

//    void saveCar(long id, String model, String mark, Color color, String dateProduction);
    void saveCar(Car car);
    List<Car> getAllCars();
    void updateCar(Car newCar);
    void deleteCar(long id);

}
