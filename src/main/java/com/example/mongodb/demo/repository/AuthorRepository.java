package com.example.mongodb.demo.repository;

import com.example.mongodb.demo.entity.Author;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends JpaRepository<Author, ObjectId> {
}
