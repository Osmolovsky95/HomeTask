package homeTaskSeven.Car;

public class Bmw extends Car {
    public Bmw(int yearCreated, String model, double capacity) {
        super(yearCreated, model, capacity);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
    public int compareTo(Bmw bmw) {
        if(this.getYearCreated()>bmw.getYearCreated()){return 1;}
        if(this.getYearCreated()<bmw.getYearCreated()){return -1;}
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
