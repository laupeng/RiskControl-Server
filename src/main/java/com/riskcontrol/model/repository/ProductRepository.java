package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Killua on 8/23/15.
 */
public interface ProductRepository extends CrudRepository<Product, String> {
}
