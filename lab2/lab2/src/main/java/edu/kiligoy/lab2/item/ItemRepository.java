package edu.kiligoy.lab2.item;/*
  @author   Dtest
  @project   lab2
  @class  ItemRepository
  @version  1.0.0 
  @since 19.03.2025 - 15.19
*/


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}