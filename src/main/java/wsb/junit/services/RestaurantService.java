package wsb.junit.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.junit.models.Restaurant;
import wsb.junit.repositories.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

}
