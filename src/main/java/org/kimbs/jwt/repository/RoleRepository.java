package org.kimbs.jwt.repository;

import org.bson.types.ObjectId;
import org.kimbs.jwt.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, ObjectId> {

    Role findByRole(String role);
}
