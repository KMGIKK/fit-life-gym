package com.fitlifegym.fit_life_gym_pos.util.mappers;

import com.fitlifegym.fit_life_gym_pos.dto.ProductDTO;
import com.fitlifegym.fit_life_gym_pos.dto.response.AllProductResponseDTO;
import com.fitlifegym.fit_life_gym_pos.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :3:22 PM
 * @since : 12/23/2024
 **/

/**
 * Mapper interface for converting between Product entities and ProductDTO objects.
 * Uses MapStruct for automatic generation of the implementation.
 * Provides methods for mapping individual objects and lists of objects.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    /**
     * Converts a ProductDTO to a Product entity.
     * @param productDTO the ProductDTO to be converted
     * @return the mapped Product entity
     */
    Product dtoToEntity(ProductDTO productDTO);

    /**
     * Converts a list of Product entities to a list of ProductDTOs.
     * @param productList the list of Product entities to be converted
     * @return the list of mapped ProductDTOs
     */
    List<ProductDTO> entityListToDtoList(List<Product> productList);

    /**
     * Converts a Page of Product entities to a list of ProductDTOs.
     * @param products the Page of Product entities to be converted
     * @return the list of mapped ProductDTOs
     */
    List<ProductDTO> listDtoToPage(Page<Product> products);
}
