package wsb.junit.services;

import org.springframework.stereotype.Service;
import wsb.junit.models.Restaurant;

import java.text.MessageFormat;

@Service
public class RestaurantNameService {

    public String getReversedName(Restaurant restaurant) {
        return new StringBuffer(restaurant.getName()).reverse().toString();
    }

    public String getFormattedAddress(Restaurant restaurant) {
        return MessageFormat.format(
                "{0} - {1}, {2}",
                restaurant.getName(),
                restaurant.getStreet(),
                restaurant.getCity());
    }

}
