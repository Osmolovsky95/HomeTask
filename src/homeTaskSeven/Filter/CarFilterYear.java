package homeTaskSeven.Filter;

import homeTaskSeven.Car.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CarFilterYear implements Searcher {
    int yearSearch;

    public CarFilterYear(int yearSearch) {
        this.yearSearch = yearSearch;
    }

    public List<Car> filter(Collection <Car> type){
        System.out.println("Поиск автомобиля "+yearSearch+" года выпуска:");
        List list1=new ArrayList();
        for (Car car:type) {
         if(car.getYearCreated()==this.yearSearch){
             list1.add(car);
         }
        }
        return list1;
    }


}
