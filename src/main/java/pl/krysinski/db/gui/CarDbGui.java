package pl.krysinski.db.gui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.krysinski.db.model.Car;
import pl.krysinski.db.service.CarService;
import pl.krysinski.db.service.CarServiceImpl;

import java.awt.*;

@Route("")
public class CarDbGui extends HorizontalLayout {

    private CarServiceImpl carService;

    Grid<Car> grid = new Grid<>(Car.class);


    @Autowired
    public CarDbGui(CarServiceImpl carService) {
        this.carService = carService;

        addCarFields();
        getCars();
    }

    public void getCars(){
        grid.setItems(carService.getCarList());
        grid.setColumns("carsId", "mark", "model", "color", "dateProduction");
        add(grid);
    }

    public void addCarFields(){
        VerticalLayout verticalLayout = new VerticalLayout();
        NumberField carId = new NumberField("ID");
        TextField carMark = new TextField("Mark");
        TextField carModel = new TextField("Model");
        TextField carColor = new TextField("Color");
        NumberField carDateProduction = new NumberField("Date production");
        Button addButton = new Button("Add");
        verticalLayout.setWidth("210px");
        verticalLayout.add(carId, carMark, carModel, carColor, carDateProduction, addButton);
        add(verticalLayout);

    }

}
