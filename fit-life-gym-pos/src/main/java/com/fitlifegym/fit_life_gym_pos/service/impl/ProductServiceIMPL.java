package com.fitlifegym.fit_life_gym_pos.service.impl;

import com.fitlifegym.fit_life_gym_pos.dto.ProductDTO;
import com.fitlifegym.fit_life_gym_pos.dto.response.AllProductResponseDTO;
import com.fitlifegym.fit_life_gym_pos.entity.GymMember;
import com.fitlifegym.fit_life_gym_pos.entity.Product;
import com.fitlifegym.fit_life_gym_pos.exception.NotFoundException;
import com.fitlifegym.fit_life_gym_pos.repository.ProductRepository;
import com.fitlifegym.fit_life_gym_pos.service.ProductService;
import com.fitlifegym.fit_life_gym_pos.util.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :3:23 PM
 * @since : 12/23/2024
 **/

/**
 * Implementation of the ProductService interface.
 * Provides business logic for managing products, including creating, retrieving, updating,
 * and deleting products, along with handling pagination for listing products.
 */

@Service
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Saves a new product based on the provided ProductDTO.
     * Maps the DTO to a Product entity and saves it to the repository.
     *
     * @param productDTO the DTO containing product data to be saved
     * @return a message indicating whether the save operation was successful or not
     */
    @Override
    public String saveProduct(ProductDTO productDTO) {
        try {
            Product product = productMapper.dtoToEntity(productDTO);
            productRepository.save(product);
            return "saved";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * Deletes a product by its unique ID.
     * If the product exists, it is deleted from the repository.
     * If the product is not found, a NotFoundException is thrown.
     *
     * @param productId the ID of the product to delete
     * @return a success message indicating the product was deleted
     * @throws NotFoundException if the product with the specified ID is not found
     */
    @Override
    public String deleteProduct(long productId) {
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return "deleted successfully " +productId;
        }else {
            throw new NotFoundException("Product Not found");
        }
    }

    /**
     * Retrieves all products with pagination support.
     * Fetches a paginated list of products from the repository and maps them to a response DTO.
     * If no products are found, a NotFoundException is thrown.
     *
     * @param page the page number to retrieve
     * @param size the number of products per page
     * @return an AllProductResponseDTO containing the list of product DTOs and the total count of products
     * @throws NotFoundException if no products are found
     */
    @Override
    public AllProductResponseDTO getAllProducts(int page,int size) {
        Page<Product> products = productRepository.findAll(PageRequest.of(page, size));
        long count = products.getTotalElements();

        if(products.getSize()<1) {
            throw new NotFoundException("products Not found");
        }

        AllProductResponseDTO allProductResponseDTO = new AllProductResponseDTO(
                productMapper.listDtoToPage(products),count
        );
            return allProductResponseDTO;
    }

    /**
     * Updates an existing product based on the provided ProductDTO.
     * Converts the DTO to an entity and saves the updated product in the repository.
     * Throws exceptions if the product ID is null or the product does not exist.
     *
     * @param productDTO the ProductDTO containing updated product details
     * @return a message indicating the success of the update operation
     * @throws IllegalArgumentException if the product ID is null
     * @throws NotFoundException if the product with the given ID is not found
     */
    @Override
    public String updateProduct(ProductDTO productDTO) {
        if (productDTO.getId() == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }

        Product product = productMapper.dtoToEntity(productDTO);
        if(productRepository.existsById(productDTO.getId())){
            productRepository.save(product);
            return productDTO.getName() + "update successfull!";
        }else {
            throw new NotFoundException("product Not found");
        }

    }


}
