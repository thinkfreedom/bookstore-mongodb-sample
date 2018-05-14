package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.Set;

@Data
public class Publisher {

    @Id
    private ObjectId id;
    private String name;
    private String Address;
    private Set<Book> publishedBooks;
}
