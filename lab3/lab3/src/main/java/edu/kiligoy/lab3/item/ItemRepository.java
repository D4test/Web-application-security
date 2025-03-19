package edu.kiligoy.lab3.item;

/*
@author   Dtest
@project   lab3
@class  ItemRepository
@version  1.0.0
@since 19.03.2025 - 19.10
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
