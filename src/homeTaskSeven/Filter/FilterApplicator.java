package homeTaskSeven.Filter;

import homeTaskSeven.Car.Car;

import java.util.Collection;
import java.util.List;

public class FilterApplicator<T extends List> {
 T type;

    public FilterApplicator(T type) {
        this.type = type;
    }

    public static Collection<Car> filter(Collection<Car> list, Searcher type){
        Collection <Car> cars= type.filter(list);
        return cars;
    }

   public static List<Car> sort(List <Car> collection){
        collection.sort(Car::compareTo);
        return collection;
    }

}
