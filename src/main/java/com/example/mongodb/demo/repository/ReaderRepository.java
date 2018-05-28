package com.example.mongodb.demo.repository;

import com.example.mongodb.demo.entity.Reader;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, ObjectId> {
}
