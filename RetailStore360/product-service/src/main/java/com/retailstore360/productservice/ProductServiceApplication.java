package com.retailstore360.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository repo) {
        return args -> {
            // Crée un produit et le sauvegarde dans PostgreSQL
            repo.save(new Product(null, "Chaussures", "Chaussures de sport", 59.99));

            // Récupère tous les produits et les affiche dans la console
            repo.findAll().forEach(System.out::println);
        };
    }
}
