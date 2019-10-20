package homeTaskSeven.Car;

public class Audi extends Car {
    public Audi(int yearCreated, String model, double capacity) {
        super(yearCreated, model, capacity);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    public int compareTo(Audi audi) {
        if(this.getYearCreated()>audi.getYearCreated()){return 1;}
        if(this.getYearCreated()<audi.getYearCreated()){return -1;}
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
