package pl.akademiaspring.week7.dao;

import pl.akademiaspring.week7.model.Car;
import pl.akademiaspring.week7.model.enums.Color;
import pl.akademiaspring.week7.model.enums.Mark;

import java.util.List;

public interface CarDao {

    void saveCar(Car car);

    List<Car> findAllCars();

    List<Car> getCarsBetweenYearsOfProduction(int yearFrom, int yearTo);
}
