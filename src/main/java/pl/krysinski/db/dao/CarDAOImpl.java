package pl.krysinski.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.krysinski.db.model.Car;
import pl.krysinski.db.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDAOImpl implements CarDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveCar(Car car) {
        String sql = "INSERT INTO cars VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, car.getCarsId(), car.getModel(), car.getMark(), car.getColor().toString(), car.getDateProduction());
    }

    @Override
    public List<Car> getAllCars() {
        String sql ="SELECT * FROM cars";
        List<Car> carList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element ->carList.add(new Car(
                Long.parseLong(String.valueOf(element.get("cars_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                Color.valueOf(String.valueOf(element.get("color"))),
                Integer.parseInt(String.valueOf(element.get("dateProduction")).substring(0,4))

        )));
        return carList;
    }

    @Override
    public void updateCar(Car newCar) {
        String sql = "UPDATE cars SET cars.model=?, cars.mark=?, cars.color=?, cars.dateProduction=? WHERE cars.cars_id=?";
        jdbcTemplate.update(sql, newCar.getModel(), newCar.getMark(), newCar.getColor().toString(), newCar.getDateProduction(), newCar.getCarsId());
    }

    @Override
    public void deleteCar(long id) {
        String sql = "DELETE FROM cars WHERE cars.cars_id=?";
        jdbcTemplate.update(sql, id);
    }
}
