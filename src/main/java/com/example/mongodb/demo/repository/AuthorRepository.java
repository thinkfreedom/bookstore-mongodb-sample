package com.example.mongodb.demo.repository;

import com.example.mongodb.demo.entity.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, ObjectId> {
}
