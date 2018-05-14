package com.example.mongodb.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;

import javax.persistence.Id;

@Data
public class Author {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }

}
