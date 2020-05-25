package simsona.springcarscemo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import simsona.springcarscemo.services.models.CarServiceModel;
import simsona.springcarscemo.services.services.CarService;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView){
        modelAndView.setViewName("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createConfirm(ModelAndView modelAndView, @ModelAttribute CarServiceModel model){
    this.carService.save(model);
    modelAndView.setViewName("redirect:/all");
        return modelAndView;
    }
    @GetMapping("/all")
    public ModelAndView allCars(ModelAndView modelAndView){
        List<CarServiceModel> models = this.carService.getCars();
        modelAndView.addObject("cars", models);
        modelAndView.setViewName("all");
        return modelAndView;
    }
}
