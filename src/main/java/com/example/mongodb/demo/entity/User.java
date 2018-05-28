package com.example.mongodb.demo.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@Builder
public class User {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
