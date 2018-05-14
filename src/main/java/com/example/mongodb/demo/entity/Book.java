package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Data
public class Book {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private Publisher publisher;
    private Set<Author> authors;
    private List<Comment> comments;
}
