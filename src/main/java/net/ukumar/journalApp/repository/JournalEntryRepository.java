package net.ukumar.journalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ukumar.journalApp.entities.JournalEntry;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

}
