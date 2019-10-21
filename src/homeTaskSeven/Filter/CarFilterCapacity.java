package homeTaskSeven.Filter;

import homeTaskSeven.Car.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarFilterCapacity <E extends Collection<?extends Car>> implements Searcher {

    double capacity;
    E element;
    public CarFilterCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Car> filter(Collection<Car> element){
        System.out.println("Поиск авто c объемом двигателя "+capacity);
        List list1=new ArrayList();
        for (Car car:element) {
            if(car.getCapacity()==this.capacity){
                list1.add(car);
            }
        }
        return list1;
    }

}
