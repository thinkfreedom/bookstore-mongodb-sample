package com.example.mongodb.demo.entity;

import com.example.mongodb.demo.annotation.CascadeSave;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@Builder
@Document(collection = "book")
public class Book {
    @Id
    private ObjectId id;
    private String title;
    private String description;

    @DBRef
    @CascadeSave
    private Publisher publisher;

    @DBRef
    @CascadeSave
    private Set<Author> authors;

    @DBRef
    @CascadeSave
    private Set<Reader> readers;

    @DBRef
    @CascadeSave
    private List<Comment> comments;
}
