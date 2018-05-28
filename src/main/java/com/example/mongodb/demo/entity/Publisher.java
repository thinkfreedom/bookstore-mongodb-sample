package com.example.mongodb.demo.entity;

import com.example.mongodb.demo.annotation.CascadeSave;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "publisher")
@Builder
public class Publisher {
    @Id
    private ObjectId id;
    private String name;
    private String address;
}
