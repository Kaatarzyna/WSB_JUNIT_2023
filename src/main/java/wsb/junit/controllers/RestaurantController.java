package wsb.junit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wsb.junit.models.Restaurant;
import wsb.junit.services.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    final RestaurantService restaurantService;

    @GetMapping
    ModelAndView index() {
        List<Restaurant> restaurants = restaurantService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("restaurants", restaurants);
        return modelAndView;
    }

}
