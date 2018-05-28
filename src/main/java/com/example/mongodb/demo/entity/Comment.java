package com.example.mongodb.demo.entity;

import com.example.mongodb.demo.annotation.CascadeSave;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "comment")
@Builder
public class Comment {
    @Id
    private ObjectId id;
    private String title;
    private String description;

    @DBRef
    @CascadeSave
    private Comment parent;

    @DBRef
    @CascadeSave
    private List<Comment> threadComments;
}
