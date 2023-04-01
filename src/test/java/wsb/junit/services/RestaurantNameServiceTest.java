package wsb.junit.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wsb.junit.models.Restaurant;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantNameServiceTest {

    @InjectMocks
    RestaurantNameService restaurantNameService;

    Restaurant restaurant;

    @BeforeEach
    void setup() {
        restaurant = new Restaurant(1L, "Restauracja", "Ulica 8", "Miasto");
    }

    @Test
    void getReversedName() {
        // arrange

        // act
        String result = restaurantNameService.getReversedName(restaurant);

        // assert
        assertEquals("ajcaruatseR", result);
    }

    @Test
    void getFormattedAddress() {
        // arrange

        // act
        String result = restaurantNameService.getFormattedAddress(restaurant);

        // assert
        assertEquals("Restauracja - Ulica 8, Miasto", result);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void getFormattedAddress_parametrized(Restaurant restaurantUnderTest, String expectedAddress) {
        // arrange

        // act
        String result = restaurantNameService.getFormattedAddress(restaurantUnderTest);

        // assert
        assertEquals(expectedAddress, result);
    }

    public static Stream<Arguments> provider() {
        return Stream.of(
          Arguments.of(new Restaurant(1L, "A", "B", "C"), "A - B, C"),
          Arguments.of(new Restaurant(2L, "N", "A", "R"), "N - A, R"),
          Arguments.of(new Restaurant(3L, "Pierogarnia", "Długa 7", "Gdańsk"), "Pierogarnia - Długa 7, Gdańsk")
        );
    }


    @Disabled
    @DisplayName("BARDZO WAŻNY TEST")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5})
    void isOdd(int number) {
        assertEquals(1, number % 2);
    }


}