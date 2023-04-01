package wsb.junit.repositories;

import org.springframework.stereotype.Repository;
import wsb.junit.models.Restaurant;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    private static List<Restaurant> restaurants = new LinkedList<>() {{
        add(new Restaurant(1L, "A", "B", "C"));
        add(new Restaurant(2L, "N", "A", "R"));
        add(new Restaurant(3L, "Pierogarnia", "Długa 7", "Gdańsk"));
    }};

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Optional<Restaurant> find(Long id) {
        return restaurants.stream().filter(r -> Objects.equals(r.getId(), id)).findFirst();
    }
}
