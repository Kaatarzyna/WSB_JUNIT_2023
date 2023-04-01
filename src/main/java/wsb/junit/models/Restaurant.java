package wsb.junit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Restaurant {

    private Long id;

    private String name;

    private String street;

    private String city;

}
