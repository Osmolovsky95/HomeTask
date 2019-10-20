package homeTaskSeven.Filter;

import homeTaskSeven.Car.Car;

import java.util.Collection;
import java.util.List;

public interface Searcher {
    public List<Car> filter(Collection<Car> list);
}
