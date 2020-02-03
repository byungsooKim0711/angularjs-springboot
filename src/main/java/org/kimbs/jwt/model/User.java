package org.kimbs.jwt.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Document(collection = "user")
@Data
public class User {

    @MongoId
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String email;

    private String password;

    private String name;

    private boolean enabled;

//    @DBRef(lazy = true)
    private Set<Role> roles;
}
