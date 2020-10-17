package pl.krysinski.db;

import org.springframework.stereotype.Component;
import pl.krysinski.db.dao.CarDAO;

@Component
public class Start {
    private CarDAO carDAO;

    public Start(CarDAO carDAO) {
        this.carDAO = carDAO;
//        carDAO.saveCar();
    }
}
