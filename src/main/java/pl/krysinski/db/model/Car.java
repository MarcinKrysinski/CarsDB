package pl.krysinski.db.model;


public class Car {

  private long carsId;
  private String mark;
  private String model;
  private Color color;
  private Integer dateProduction;

  public Car(long carsId, String mark, String model, Color color, Integer dateProduction) {
    this.carsId = carsId;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.dateProduction = dateProduction;
  }

  public Car() {
  }

  public long getCarsId() {
    return carsId;
  }

  public void setCarsId(long carsId) {
    this.carsId = carsId;
  }


  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }


  public Integer getDateProduction() {
    return dateProduction;
  }

  public void setDateProduction(Integer dateProduction) {
    this.dateProduction = dateProduction;
  }

  @Override
  public String toString() {
    return "Car{" +
            "carsId=" + carsId +
            ", mark='" + mark + '\'' +
            ", model='" + model + '\'' +
            ", color=" + color +
            ", dateProduction='" + dateProduction + '\'' +
            '}';
  }
}
