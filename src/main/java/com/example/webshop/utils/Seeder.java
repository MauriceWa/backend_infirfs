package com.example.webshop.utils;

import com.example.webshop.dao.ProductDAO;
import com.example.webshop.models.Category;
import com.example.webshop.models.Product;
import com.example.webshop.models.CustomUser;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.webshop.dao.UserRepository;


@Component
public class Seeder {
    private ProductDAO productDAO;
    private final PasswordEncoder passwordEncoder;
    private CustomUser customUser;
    private UserRepository userDAO;

    public Seeder(ProductDAO productDAO, PasswordEncoder passwordEncoder, UserRepository userDAO) {
        this.productDAO = productDAO;
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedProducts();
    }

    private void seedProducts(){
        Category sneakers = new Category("Sneakers");

        Product product1 = new Product("Blue Sneakers", "Classic blue sneakers with a modern twist.",10 , 22.99, "bluesneakers.png","appelmoes", sneakers);
        Product product2 = new Product("Black & White Sneakers", "Stylish black sneakers with white soles.",10 , 19.99, "black_sneakers.png","appelmoes", sneakers);
        Product product3 = new Product("All Black Sneakers", "Sleek all-black sneakers for every occasion.",10 , 35.99, "blackblack_sneakers.png","appelmoes", sneakers);
        Product product4 = new Product("Blue & White Sneakers", "Sporty blue sneakers with white accents.",10 , 25.99, "bluewhite_sneakers.png","appelmoes", sneakers);
        Product product5 = new Product("Camo Carpet Sneakers", "Urban camo sneakers for the street-style enthusiast.",10 , 49.99, "carpet_sneakers.png","appelmoes", sneakers);
        Product product6 = new Product("Green Sneakers", "Fresh green sneakers to stand out.",10 , 39.99, "green_sneakers.png","appelmoes", sneakers);
        Product product7 = new Product("Light Blue Sneakers", "Airy and light blue sneakers for daily wear.",10 , 24.99, "lightblue_sneakers.png","appelmoes", sneakers);
        Product product8 = new Product("Red Sneakers", "Bold red sneakers to make a statement.",10 , 39.99, "red_sneakers.png","appelmoes", sneakers);
        Product product9 = new Product("White Sneakers", "Clean white sneakers for a crisp look.",10 , 20.99, "white_sneakers.png","appelmoes", sneakers);
        Product product10 = new Product("Yellow & Black Sneakers", "Vibrant yellow sneakers with black highlights.",10 , 49.99, "yellowblack_sneakers.png","appelmoes", sneakers);

        this.productDAO.createProduct(product1);
        this.productDAO.createProduct(product2);
        this.productDAO.createProduct(product3);
        this.productDAO.createProduct(product4);
        this.productDAO.createProduct(product5);
        this.productDAO.createProduct(product6);
        this.productDAO.createProduct(product7);
        this.productDAO.createProduct(product8);
        this.productDAO.createProduct(product9);
        this.productDAO.createProduct(product10);



        String encodedPassword = passwordEncoder.encode("admin");
        CustomUser user = new CustomUser("admin", encodedPassword, "ROLE_ADMIN");
        this.userDAO.save(user);

    }
}
