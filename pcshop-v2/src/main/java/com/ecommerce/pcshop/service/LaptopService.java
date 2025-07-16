package com.ecommerce.pcshop.service;

import com.ecommerce.pcshop.model.Laptop;
import com.ecommerce.pcshop.repository.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private final LaptopRepository repository;

    public LaptopService(LaptopRepository repository) {
        this.repository = repository;
    }

    public List<Laptop> getAllLaptops() {
        return repository.findAll();
    }
}
