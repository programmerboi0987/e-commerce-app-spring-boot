package com.ecommerce.pcshop.service;

import com.ecommerce.pcshop.model.PcComponent;
import com.ecommerce.pcshop.repository.PcComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcComponentService {

    private final PcComponentRepository repository;

    public PcComponentService(PcComponentRepository repository) {
        this.repository = repository;
    }

    public List<PcComponent> getAllComponents() {
        return repository.findAll();
    }
}
