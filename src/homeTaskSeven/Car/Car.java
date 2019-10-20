package homeTaskSeven.Car;

public abstract class Car implements ICar,Comparable {
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

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Car(int yearCreated, String model, double capacity) {
        this.yearCreated = yearCreated;
        this.model = model;
        this.capacity = capacity;
    }

    public int compareTo(Car car) {
        if(this.getYearCreated()>car.getYearCreated()){return 1;}
        if(this.getYearCreated()<car.getYearCreated()){return -1;}
        return 0;
    }






}
