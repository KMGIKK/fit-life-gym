package com.fitlifegym.fit_life_gym_pos.dto.response;

import com.fitlifegym.fit_life_gym_pos.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :4:00 PM
 * @since : 12/23/2024
 **/

/**
 * Data Transfer Object (DTO) that represents the response structure
 * for retrieving all products.
 * Contains a list of products and the total count of data.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllProductResponseDTO {
    /**
     * A list of ProductDTO objects representing individual product details.
     */
    private List<ProductDTO> list;

    /**
     * The total number of products in the dataset.
     * Useful for pagination or displaying the total product count.
     */
    private  long dataCount;
}
