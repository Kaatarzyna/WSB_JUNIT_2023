package wsb.junit.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wsb.junit.models.Restaurant;
import wsb.junit.services.RestaurantService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestaurantService restaurantService;

    @Test
    void index() throws Exception {
        // arrange
        List<Restaurant> restaurants = List.of(new Restaurant(3L, "Pierogarnia", "Długa 7", "Gdańsk"));
        Mockito.when(restaurantService.findAll()).thenReturn(restaurants);

        // act
        mockMvc.perform(get("/restaurants"))
        // assert
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("restaurants", restaurants));
    }
}