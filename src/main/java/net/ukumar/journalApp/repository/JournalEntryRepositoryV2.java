package net.ukumar.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.ukumar.journalApp.entities.JournalEntryV2;

public interface JournalEntryRepositoryV2 extends MongoRepository<JournalEntryV2, ObjectId> {

}
