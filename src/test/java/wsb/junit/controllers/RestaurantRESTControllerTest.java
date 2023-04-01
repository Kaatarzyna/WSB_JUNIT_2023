package wsb.junit.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wsb.junit.exceptions.RestaurantNotFoundException;
import wsb.junit.models.Restaurant;
import wsb.junit.services.RestaurantService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantRESTController.class)
class RestaurantRESTControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestaurantService restaurantService;


    @Test
    void find_whenRestaurantFound_thenReturnRestaurant() throws Exception {
        // arrange
        Restaurant restaurant = new Restaurant(3L, "Pierogarnia", "Długa 7", "Gdańsk");
        Mockito.when(restaurantService.find(3L)).thenReturn(restaurant);

        // act
        mockMvc.perform(get("/3"))
                // asssert
                .andExpect(status().isOk());
    }

    @Test
    void find_whenRestaurantNotFound_thenReturn404() throws Exception {
        // arrange
        Mockito.when(restaurantService.find(3L)).thenThrow(new RestaurantNotFoundException());

        // act
        mockMvc.perform(get("/3"))
                // asssert
                .andExpect(status().isNotFound());
    }
}