package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Items;

@Repository
public interface ItemListRepository extends JpaRepository<Items, Long> {

}
