package net.ukumar.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.ukumar.journalApp.entities.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}
