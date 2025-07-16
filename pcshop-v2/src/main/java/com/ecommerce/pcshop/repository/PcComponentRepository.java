package com.ecommerce.pcshop.repository;

import com.ecommerce.pcshop.model.PcComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcComponentRepository extends JpaRepository<PcComponent, Long> {
}
