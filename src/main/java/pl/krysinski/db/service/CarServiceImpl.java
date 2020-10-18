package pl.krysinski.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysinski.db.dao.CarDAO;
import pl.krysinski.db.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private CarDAO carDAO;

    @Autowired
    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getCarList() {
        
        return carDAO.getAllCars();
    }

    @Override
    public List<Car> findCarsFromTheRange(int lowDateProduction, int maxDateProduction) {
        List<Car> carList = carDAO.getAllCars();
        if (lowDateProduction > maxDateProduction){
            int temp = maxDateProduction;
            maxDateProduction = lowDateProduction;
            lowDateProduction = temp;
        }

        int finalLowDateProduction = lowDateProduction;
        int finalMaxDateProduction = maxDateProduction;
        return carList.stream().filter(car -> finalLowDateProduction <= car.getDateProduction() && finalMaxDateProduction >= car.getDateProduction()).collect(Collectors.toList());
    }

    @Override
    public void addCar(Car newCar) {
        carDAO.saveCar(newCar);
    }

    @Override
    public void deleteCar(long id) {
        carDAO.deleteCar(id);
    }
}
