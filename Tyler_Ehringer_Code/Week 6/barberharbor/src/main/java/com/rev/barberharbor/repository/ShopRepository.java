package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

}
