package com.ecommerce.pcshop.bootstrap;

import com.ecommerce.pcshop.model.Laptop;
import com.ecommerce.pcshop.model.PcComponent;
import com.ecommerce.pcshop.repository.PcComponentRepository;
import com.ecommerce.pcshop.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LaptopRepository laptopRepository;

    public DataLoader(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    private void loadLaptopData() {
        if (laptopRepository.count() == 0) {
            laptopRepository.save(new Laptop(null, "Dell", "XPS 15", 1499.99, "15-inch laptop with InfinityEdge display", "/images/laptops/dell-xps-15.jpg"));
            laptopRepository.save(new Laptop(null, "HP", "Spectre x360", 1399.99, "Convertible laptop with touch screen", "/images/laptops/hp-spectre.jpg"));
            laptopRepository.save(new Laptop(null, "Apple", "MacBook Pro 14", 1999.00, "M2 Pro chip with 14-inch Retina display", "/images/laptops/macbook-pro.jpg"));

            System.out.println("Sample laptops loaded.");
        }
    }

    @Autowired
    private PcComponentRepository pcComponentRepository;

    private void loadComponentData() {
        if (pcComponentRepository.count() == 0) {
            pcComponentRepository.save(new PcComponent(null, "CPU", "Intel", "Core i7 13700K", 369.99, "High performance 13th Gen processor", "/images/pc-components/intel-i7.jpg"));
            pcComponentRepository.save(new PcComponent(null, "GPU", "NVIDIA", "RTX 4070", 599.99, "Next-gen graphics card for gaming and AI", "/images/pc-components/rtx-4070.jpg"));
            pcComponentRepository.save(new PcComponent(null, "RAM", "Corsair", "Vengeance 16GB DDR5", 89.99, "High-speed memory module", "/images/pc-components/corsair-ram.jpg"));
            pcComponentRepository.save(new PcComponent(null, "SSD", "Samsung", "980 PRO 1TB", 119.99, "PCIe 4.0 NVMe M.2 SSD", "/images/pc-components/samsung-ssd.jpg"));

            System.out.println("Sample computer components loaded.");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        loadLaptopData();
        loadComponentData();
    }
}
