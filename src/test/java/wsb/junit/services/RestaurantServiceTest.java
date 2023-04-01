package wsb.junit.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wsb.junit.exceptions.RestaurantNotFoundException;
import wsb.junit.models.Restaurant;
import wsb.junit.repositories.RestaurantRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @InjectMocks
    RestaurantService restaurantService;

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

    @Test
    void find_whenExists_thenReturnRestaurant() throws RestaurantNotFoundException {
        // arrange
        Restaurant restaurant = new Restaurant(1L, "Test", "Ulica", "Miasto");
        Mockito.when(restaurantRepository.find(1L)).thenReturn(Optional.of(restaurant));

        // act
        Restaurant result = restaurantService.find(1L);

        // assert
        assertEquals(restaurant, result);
    }

    @Test
    void find_whenNotExists_thenThrowRestaurantNotFoundException() {
        // arrange
        Mockito.when(restaurantRepository.find(1L)).thenReturn(Optional.empty());

        // act
        Executable executable = () -> restaurantService.find(1L);

        // assert
        assertThrows(RestaurantNotFoundException.class, executable);
    }
}