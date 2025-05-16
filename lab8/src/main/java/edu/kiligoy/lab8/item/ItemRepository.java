package edu.kiligoy.lab8.item;

/*
@author   Dtest
@project   lab5
@class  ItemRepository
@version  1.0.0
@since 08.04.2025 - 13.11
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
