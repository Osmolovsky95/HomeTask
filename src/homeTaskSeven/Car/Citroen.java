package homeTaskSeven.Car;

public class Citroen extends Car {
    public Citroen(int yearCreated, String model, double capacity) {
        super(yearCreated, model, capacity);
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }


    @Override
    public int compareTo(Car car) {
        if (this.getYearCreated() > car.getYearCreated()) {
            return 1;
        }
        if (this.getYearCreated() < car.getYearCreated()) {
            return -1;
        }
        return 0;
    }
}

