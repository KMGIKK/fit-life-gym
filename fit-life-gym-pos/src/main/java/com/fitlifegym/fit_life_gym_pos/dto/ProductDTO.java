package com.fitlifegym.fit_life_gym_pos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:59 PM
 * @since : 12/23/2024
 **/


/**
 * Data Transfer Object (DTO) for representing a product in the system.
 * Contains details about the product, including its name, quantity, and price.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private int quantity;
    private Double price;
}
