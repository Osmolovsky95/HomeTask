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

    public int compareTo(Citroen citroen) {
            if(this.getYearCreated()>citroen.getYearCreated()){
                return 1;
            }
            if(this.getYearCreated()<citroen.getYearCreated()){
                return -1;
            }
            return 0;
        }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

