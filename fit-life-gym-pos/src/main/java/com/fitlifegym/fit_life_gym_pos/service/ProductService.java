package com.fitlifegym.fit_life_gym_pos.service;

import com.fitlifegym.fit_life_gym_pos.dto.ProductDTO;
import com.fitlifegym.fit_life_gym_pos.dto.response.AllProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :3:22 PM
 * @since : 12/23/2024
 **/

@Service
public interface ProductService {
    String saveProduct(ProductDTO productDTO);

    String deleteProduct(long productId);

    AllProductResponseDTO getAllProducts(int page,int size);

    String updateProduct(ProductDTO productDTO);
}
