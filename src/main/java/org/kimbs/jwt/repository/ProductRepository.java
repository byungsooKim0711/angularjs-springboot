package org.kimbs.jwt.repository;

import org.bson.types.ObjectId;
import org.kimbs.jwt.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
}
