package com.example.todoappdeel3.utils;

import com.example.todoappdeel3.dao.ProductDAO;
import com.example.todoappdeel3.dao.UserRepository;
import com.example.todoappdeel3.dto.ProductDTO;
import com.example.todoappdeel3.models.CustomUser;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
    private ProductDAO productDAO;
    private UserRepository userRepository;

    public Seeder(ProductDAO productDAO, UserRepository userRepository) {
        this.productDAO = productDAO;
        this.userRepository = userRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedProducts();
        this.seedUser();
    }

    private void seedProducts(){
        ProductDTO product1 = new ProductDTO("AirPods", "The latest and greatest", 249.95);
        ProductDTO product2 = new ProductDTO("iPad Pro", "Now with a bigger screen!", 799);
        this.productDAO.createProduct(product1);
        this.productDAO.createProduct(product2);
    }

    private void seedUser(){
        CustomUser customUser = new CustomUser();
        customUser.setEmail("test@mail.com");
        customUser.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        userRepository.save(customUser);
    }
}
