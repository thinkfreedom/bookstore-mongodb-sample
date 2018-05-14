package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Data
@Document(collection = "book")
public class Book {
    @Id
    private ObjectId id;
    private String title;
    private String description;

    @DBRef
    @Cascade(CascadeType.SAVE_UPDATE)
    private Publisher publisher;

    @DBRef
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Author> authors;

    @DBRef
    @Cascade(CascadeType.ALL)
    private List<Comment> comments;
}
