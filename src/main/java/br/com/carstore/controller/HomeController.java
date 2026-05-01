package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private CarService service;

    @Autowired
    public HomeController(CarService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(CarDTO carDTO, BindingResult result) {

        if (carDTO.getId() != null && !carDTO.getId().isBlank()) {

            service.update(carDTO.getId(), carDTO);

        } else {

            service.save(carDTO);

        }

        return "redirect:/cars";

    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<CarDTO> allCars = service.findAll();
        model.addAttribute("cars", allCars);
        return "dashboard";
    }

    @GetMapping("/cars/edit")
    public String editCar(@RequestParam("id") String id, Model model) {

        // CarDTO car = service.findById(id);

        CarDTO car = new CarDTO();

        if (car == null) {

            return "redirect:/cars";

        }
        model.addAttribute("carDTO", car);

        return "index";

    }

    @PostMapping("/cars/delete")
    public String deleteCar(@RequestParam("id") String id, Model model) {

        service.deleteById(id);

        List<CarDTO> cars = service.findAll();
        model.addAttribute("cars", cars);

        return "redirect:/cars";

    }

}
