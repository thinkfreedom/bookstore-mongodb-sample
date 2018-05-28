package com.example.mongodb.demo.repository;

import com.example.mongodb.demo.entity.Publisher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher, ObjectId> {
}
