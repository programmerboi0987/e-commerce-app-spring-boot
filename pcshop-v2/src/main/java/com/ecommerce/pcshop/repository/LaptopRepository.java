package com.ecommerce.pcshop.repository;

import com.ecommerce.pcshop.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}

