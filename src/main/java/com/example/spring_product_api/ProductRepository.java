/**
 * Created by mupezeni for spring_product_api
 * User: mupezeni
 * Date: 10/9/2022
 * Time: 14:11
 */

package com.example.spring_product_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


}
