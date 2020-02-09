package sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private int id;
    private String name;
    private String type;
    private int wholesale_price;
    private int retail_price;
    private int provider_id;
    private int count;

}
