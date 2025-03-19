package edu.kiligoy.lab1.item;/*
  @author   Dtest
  @project   lab1
  @class  ItemRepository
  @version  1.0.0 
  @since 19.03.2025 - 15.04
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
