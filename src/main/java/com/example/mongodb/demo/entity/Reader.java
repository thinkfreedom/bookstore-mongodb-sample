package com.example.mongodb.demo.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reader")
@Builder
public class Reader {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
}
