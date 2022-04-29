package com.example.webparser.interfaces.dao;

import com.example.webparser.entity.CSGOItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSGOItemRepository extends CrudRepository<CSGOItem, Long> {
}
