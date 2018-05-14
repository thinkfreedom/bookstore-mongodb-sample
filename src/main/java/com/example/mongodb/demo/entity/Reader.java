package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;

@Data
public class Reader {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
}
