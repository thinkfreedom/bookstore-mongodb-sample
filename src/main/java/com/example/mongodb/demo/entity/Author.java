package com.example.mongodb.demo.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Author {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }
}
