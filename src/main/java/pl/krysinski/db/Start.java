package pl.krysinski.db;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krysinski.db.model.Car;
import pl.krysinski.db.model.Color;
import pl.krysinski.db.service.CarService;

import java.util.List;

@Component
public class Start {
    private CarService carService;


    public Start(CarService carService) {
        this.carService = carService;

    }

//    @EventListener(ApplicationReadyEvent.class)
    public void showAllCars(){
//        carService.addCar(new Car(3L, "Opel", "Vivaro", Color.Blue, 2010));
//        List<Car> carList = carService.getCarList();
        List<Car> carList= carService.findCarsFromTheRange(2006, 2011);
        System.out.println(carList);
    }
}
