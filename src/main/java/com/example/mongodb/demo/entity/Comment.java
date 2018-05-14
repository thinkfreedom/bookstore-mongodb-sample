package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

@Data
public class Comment {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private List<Comment> subComments;
}
