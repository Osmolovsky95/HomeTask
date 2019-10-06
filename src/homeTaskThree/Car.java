package homeTaskThree;

public class Car {
    private String model;
    private int yearCreate;

    public Car(String model, int yearCreate) {
        this.model = model;
        this.yearCreate = yearCreate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", yearCreate='" + yearCreate + '\'' +
                '}';
    }
}
