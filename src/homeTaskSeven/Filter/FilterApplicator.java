package homeTaskSeven.Filter;

import homeTaskSeven.Car.Car;

import java.util.Collection;
import java.util.List;

public class FilterApplicator<E extends Collection,T extends Searcher> {

    public  Collection filter(E collection, T type){
       collection= (E) type.filter(collection);
        return collection;
    }

    public static List<Car> sort(List <Car> collection){
        collection.sort(Car::compareTo);
        return collection;
    }

}
