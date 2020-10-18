package pl.krysinski.db.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.krysinski.db.model.Car;
import pl.krysinski.db.model.Color;
import pl.krysinski.db.service.CarServiceImpl;

import java.util.List;


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
        grid.setHeight("530px");
        add(grid);
    }

    public void addCarFields(){
        VerticalLayout verticalLayout = new VerticalLayout();
        TextField carId = new TextField("Add car:");
        TextField carMark = new TextField();
        TextField carModel = new TextField();
        TextField carColor = new TextField();
        TextField carDateProduction = new TextField();
        Button addButton = new Button("Add");

        TextField fromField = new TextField("Search by year of production");
        TextField toField = new TextField();
        Button searchButton = new Button("Search");

        TextField idField = new TextField("Delete car by id:");
        Button deleteButton = new Button("Delete");
        Button refreshButton = new Button("Refresh table");

        carId.setPlaceholder("id");
        carMark.setPlaceholder("mark");
        carModel.setPlaceholder("model");
        carColor.setPlaceholder("color");
        carDateProduction.setPlaceholder("year of production:");
        carDateProduction.setWidth("190px");
        addButton.addThemeName("primary");
        addButton.addClickListener(event -> {
            Car newCar = new Car(Long.parseLong(carId.getValue()), carMark.getValue(), carModel.getValue(),
                    Color.valueOf(carColor.getValue()), Integer.parseInt(carDateProduction.getValue()));
            carService.addCar(newCar);
            getCars();
            carId.clear();
            carMark.clear();
            carModel.clear();
            carColor.clear();
            carDateProduction.clear();

        });

        fromField.setPlaceholder("From:");
        toField.setPlaceholder("To:");
        searchButton.addThemeName("primary");
        searchButton.addClickListener(event -> {
            int fromYear = Integer.parseInt(fromField.getValue());
            int toYear = Integer.parseInt(toField.getValue());
            List<Car> findCarList = carService.findCarsFromTheRange(fromYear, toYear);
            grid.setItems(findCarList);
            grid.setColumns("carsId", "mark", "model", "color", "dateProduction");
            grid.getDataProvider().refreshAll();
        });

        verticalLayout.setWidth("210px");
        verticalLayout.add(fromField, toField, searchButton);
        add(verticalLayout);

        idField.setPlaceholder("Id");
        deleteButton.addThemeName("primary");
        deleteButton.addClickListener(event -> {
            long id = Long.parseLong(idField.getValue());
            carService.deleteCar(id);
            getCars();
            idField.clear();

        });

        refreshButton.addClickListener(event -> {
            getCars();
            carId.clear();
            carMark.clear();
            carModel.clear();
            carColor.clear();
            carDateProduction.clear();
        });

        verticalLayout.setWidth("210px");
        verticalLayout.add(fromField, toField, searchButton, carId, carMark, carModel, carColor, carDateProduction, addButton, idField, deleteButton, refreshButton);
        add(verticalLayout);

    }

}
