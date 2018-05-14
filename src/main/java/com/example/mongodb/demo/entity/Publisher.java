package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Set;

@Data
@Document(collection = "publisher")
public class Publisher {
    @Id
    private ObjectId id;
    private String name;
    private String Address;

    @DBRef
    private Set<Book> publishedBooks;
}
