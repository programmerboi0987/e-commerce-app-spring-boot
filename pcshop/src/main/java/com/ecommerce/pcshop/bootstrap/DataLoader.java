package com.ecommerce.pcshop.bootstrap;

import com.ecommerce.pcshop.model.Laptop;
import com.ecommerce.pcshop.repository.LaptopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LaptopRepository laptopRepository;

    public DataLoader(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (laptopRepository.count() == 0) {
            laptopRepository.save(new Laptop(null, "Dell", "XPS 15", 1499.99, "15-inch laptop with InfinityEdge display", "/images/dell-xps-15.jpg"));
            laptopRepository.save(new Laptop(null, "HP", "Spectre x360", 1399.99, "Convertible laptop with touch screen", "/images/hp-spectre.jpg"));
            laptopRepository.save(new Laptop(null, "Apple", "MacBook Pro 14", 1999.00, "M2 Pro chip with 14-inch Retina display", "/images/macbook-pro.jpg"));

            System.out.println("Sample laptops loaded.");
        }
    }
}
