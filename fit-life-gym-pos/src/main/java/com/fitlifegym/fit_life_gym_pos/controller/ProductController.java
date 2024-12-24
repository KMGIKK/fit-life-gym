package com.fitlifegym.fit_life_gym_pos.controller;
import com.fitlifegym.fit_life_gym_pos.dto.ProductDTO;
import com.fitlifegym.fit_life_gym_pos.dto.response.AllProductResponseDTO;
import com.fitlifegym.fit_life_gym_pos.service.ProductService;
import com.fitlifegym.fit_life_gym_pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author : K.M.G.I.K.konara
 * @Time :3:21 PM
 * @since : 12/23/2024
 **/

/**
 * REST controller for managing products in the POS system.
 * Provides endpoints for creating, updating, deleting, and retrieving product information.
 */

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Adds a new product to the system.
     *
     * @param productDTO the product data transfer object containing product details.
     * @return a ResponseEntity containing a StandardResponse with the operation's result.
     *         Status code 201 (Created) is returned upon success.
     */

    @PostMapping("/save-product")
    public ResponseEntity<StandardResponse> addGymProduct(@RequestBody ProductDTO productDTO){
        String message = productService.saveProduct(productDTO);
        return new ResponseEntity<StandardResponse> (new StandardResponse(201,"success",message), HttpStatus.CREATED);

    }

    /**
     * Updates an existing product in the system.
     *
     * @param productDTO the product data transfer object containing updated product details.
     * @return a ResponseEntity containing a StandardResponse with the operation's result.
     *         Status code 200 (OK) is returned upon success.
     */

    @PutMapping("/update-product")
    public ResponseEntity<StandardResponse> updateProduct(@RequestBody ProductDTO productDTO){
        String message = productService.updateProduct(productDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "success", message),HttpStatus.OK);
    }

    /**
     * Deletes a product from the system based on its ID.
     *
     * @param productId the ID of the product to be deleted.
     * @return a ResponseEntity containing a StandardResponse with the operation's result.
     *         Status code 200 (OK) is returned upon success.
     */

    @DeleteMapping(path = "/delete-product", params = "id")
    public ResponseEntity<StandardResponse> deleteMember(@RequestParam(value = "id" )long productId) {
        String message = productService.deleteProduct(productId);
        return new ResponseEntity<>(new StandardResponse(200, "success", message), HttpStatus.OK);
    }

    /**
     * Retrieves all products from the system with pagination.
     *
     * @param page the page number of the requested data (zero-based index).
     * @param size the number of records per page.
     * @return a ResponseEntity containing a StandardResponse with the list of products
     *         and additional pagination details in an AllProductResponseDTO.
     *         Status code 200 (OK) is returned upon success.
     */

    @GetMapping(path= "/get-all-product", params = {"page","size"})
    public ResponseEntity<StandardResponse> getAllProducts(@RequestParam int page, @RequestParam int size){
        //List<ProductDTO> allProducts = productService.getAllProducts();



        AllProductResponseDTO allProductResponseDTO = productService.getAllProducts(page,size);

        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"success",allProductResponseDTO),HttpStatus.OK);
    }

}
