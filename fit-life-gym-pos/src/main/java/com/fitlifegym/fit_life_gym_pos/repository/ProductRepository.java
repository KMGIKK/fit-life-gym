package com.fitlifegym.fit_life_gym_pos.repository;

import com.fitlifegym.fit_life_gym_pos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author : K.M.G.I.K.konara
 * @Time :3:23 PM
 * @since : 12/23/2024
 **/
@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {


}
