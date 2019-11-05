package pl.akademiaspring.week7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiaspring.week7.dao.CarDao;
import pl.akademiaspring.week7.model.Car;
import pl.akademiaspring.week7.validators.CarValidator;

import java.util.List;

@Controller
public class CarApi {

    private CarDao carDao;

    @Autowired
    public CarApi(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/add-car")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());

        return "addCar";
    }

    @GetMapping("/get-all-cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carDao.findAllCars());

        return "listCars";
    }

    @GetMapping("/search-cars-production-years")
    public String searchCarsByYears(Model model) {
        model.addAttribute("queryObject", new QueryHelpObject());

        return "SearchCarsByYears";
    }

    @GetMapping("/get-cars-production-years")
    public String getCarsByYears(@ModelAttribute("queryObject") QueryHelpObject query, Model model) {

        List<Car> cars = carDao.getCarsBetweenYearsOfProduction(query.getYearFrom(), query.getYearTo());
        model.addAttribute("cars", cars);

        return "listCars";
    }

    @PostMapping("/save-new-car")
    public String saveNewCar(@ModelAttribute Car car, BindingResult result) {

        new CarValidator().validate(car, result);

        if (result.hasErrors()) {
            return "addCar";
        }

        carDao.saveCar(car);

        return "redirect:/get-all-cars";
    }

}
