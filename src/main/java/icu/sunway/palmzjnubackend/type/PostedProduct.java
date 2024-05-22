package icu.sunway.palmzjnubackend.type;

import lombok.Data;

@Data
public class PostedProduct {

    private String name;

    private Double price;

    private Integer stock;

    private String description;

    private Integer categoryId;
}
