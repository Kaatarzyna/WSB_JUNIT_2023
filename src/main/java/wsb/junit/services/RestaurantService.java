package wsb.junit.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.junit.exceptions.RestaurantNotFoundException;
import wsb.junit.models.Restaurant;
import wsb.junit.repositories.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant find(Long id) throws RestaurantNotFoundException {
        return restaurantRepository.find(id).orElseThrow(RestaurantNotFoundException::new);
    }

}
