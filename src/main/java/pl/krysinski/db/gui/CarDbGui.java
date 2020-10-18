package pl.krysinski.db.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.krysinski.db.model.Car;
import pl.krysinski.db.service.CarServiceImpl;


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
        NumberField carId = new NumberField("Add car:");
        TextField carMark = new TextField();
        TextField carModel = new TextField();
        TextField carColor = new TextField();
        NumberField carDateProduction = new NumberField();
        Button addButton = new Button("Add");

        TextField fromField = new TextField("Search by year of production");
        TextField toField = new TextField();
        Button searchButton = new Button("Search");

        NumberField idField = new NumberField("Delete car by id:");
        Button deleteButton = new Button("Delete");

        carId.setPlaceholder("id");
        carMark.setPlaceholder("mark");
        carModel.setPlaceholder("model");
        carColor.setPlaceholder("color");
        carDateProduction.setPlaceholder("year of production:");
        carDateProduction.setWidth("190px");
        addButton.addThemeName("primary");

        fromField.setPlaceholder("From:");
        toField.setPlaceholder("To:");
        searchButton.addThemeName("primary");
        verticalLayout.setWidth("210px");
        verticalLayout.add(fromField, toField, searchButton);
        add(verticalLayout);

        idField.setPlaceholder("Id");
        deleteButton.addThemeName("primary");

        verticalLayout.setWidth("210px");
        verticalLayout.add(carId, carMark, carModel, carColor, carDateProduction, addButton, idField,deleteButton);
        add(verticalLayout);

    }

}
