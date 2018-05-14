package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;

@Data
public class Comment {
    @Id
    private ObjectId id;
    private String title;
    private String description;
}
