package homeTaskSeven;


import homeTaskSeven.Car.*;
import homeTaskSeven.Filter.*;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Create car and list
        Car citroenC5 = new Citroen(2002, "C5", 1.8);
        Car audiA6 = new Audi(2007, "A6", 2.0);
        Car bmw7 = new Bmw(2010, "715", 3.0);
        Car citroenC4 = new Citroen(2007, "C4", 1.6);
        Car audiA8 = new Audi(2012, "A8", 1.4);
        Car citroenC2 = new Citroen(2010, "C2", 1.2);
        Car audiA3 = new Audi(2010, "A3", 1.2);
        Car  bmw3 = new Bmw(2011, "315", 1.8);
        List<Car> carList = new ArrayList<>();
        //add car to list
        carList.add(citroenC5);
        carList.add(audiA6);
        carList.add(bmw7);
        carList.add(citroenC4);
        carList.add(audiA8);
        carList.add(bmw3);
        carList.add(citroenC2);
        carList.add(audiA3);
        CarFilterYear carFilterYear=new CarFilterYear(2007);
        CarFilterCapacity carFilterCapacity=new CarFilterCapacity(1.2);
        //filter
       System.out.println( FilterApplicator.filter(carList,carFilterYear));
       System.out.println( FilterApplicator.filter(carList,carFilterCapacity));
       FilterApplicator.sort(carList);
       System.out.println(carList);


    }
}
