package wsb.junit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wsb.junit.models.Restaurant;
import wsb.junit.services.RestaurantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class RestaurantRESTController {

    final RestaurantService restaurantService;

    @GetMapping
    List<Restaurant> findAll() {
        return restaurantService.findAll();
    }


}
