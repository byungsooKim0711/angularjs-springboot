package org.kimbs.jwt.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "product")
@Data
public class Product {

    @MongoId
    private String id;

    private String name;

    private String description;

    private long price;

    private String image;
}
