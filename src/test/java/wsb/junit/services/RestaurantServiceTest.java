package wsb.junit.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wsb.junit.models.Restaurant;
import wsb.junit.repositories.RestaurantRepository;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @InjectMocks RestaurantService restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Test
    void findAll() {
        // arrange
        List<Restaurant> restaurants = new LinkedList<>();
        restaurants.add(new Restaurant(1L, "Test", "Ulica", "Miasto"));
        Mockito.when(restaurantRepository.findAll()).thenReturn(restaurants);

        // act
        List<Restaurant> result = restaurantService.findAll();

        // assert
        assertEquals(restaurants, result);
    }
}