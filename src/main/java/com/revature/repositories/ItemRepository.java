package com.revature.repositories;

import com.revature.entities.Item;
import com.revature.utils.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    Item findByNameAndMaterialAllIgnoreCase(String name, Material material);
}
