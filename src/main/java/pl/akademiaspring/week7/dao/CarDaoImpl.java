package pl.akademiaspring.week7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.week7.model.Car;
import pl.akademiaspring.week7.model.enums.Color;
import pl.akademiaspring.week7.model.enums.Mark;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(Car car) {
        String sql = "INSERT INTO cars (mark, model, color, production_year) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getMark().name(), car.getModel(), car.getColor().name(), car.getProductionYear());
    }

    @Override
    public List<Car> findAllCars() {
        String sql = "SELECT * FROM cars";
        return parseQueryResults(sql);
    }

    @Override
    public List<Car> getCarsBetweenYearsOfProduction(int yearFrom, int yearTo) {
        String sql = "SELECT * FROM cars WHERE production_year BETWEEN " + yearFrom + " AND " + yearTo +
                " ORDER BY production_year";
        return parseQueryResults(sql);
    }

    private List<Car> parseQueryResults(String sql) {
        List<Car> carList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(element -> carList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("production_year")))
        )));
        return carList;
    }
}
