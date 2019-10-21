package homeTaskSeven.Car;

public abstract class Car implements ICar,Comparable<Car> {
    @Override
    public String toString() {
        return "Car"
                + this.getClass()+
                " год выпуска=" + yearCreated +
                ", модель='" + model + '\'' +
                ", объем двигателя=" + capacity;
    }

    private int yearCreated;
    private String model;
    private double capacity;

    public int getYearCreated() {
        return yearCreated;
    }

    public double getCapacity() {
        return capacity;
    }

    public Car(int yearCreated, String model, double capacity) {
        this.yearCreated = yearCreated;
        this.model = model;
        this.capacity = capacity;
    }

}
