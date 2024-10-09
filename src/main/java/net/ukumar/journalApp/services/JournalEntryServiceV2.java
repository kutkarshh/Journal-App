package net.ukumar.journalApp.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import net.ukumar.journalApp.entities.JournalEntryV2;
import net.ukumar.journalApp.repository.JournalEntryRepositoryV2;

@Service
public class JournalEntryServiceV2 {

    private final JournalEntryRepositoryV2 journalEntryRepository;

    public JournalEntryServiceV2(JournalEntryRepositoryV2 journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public List<JournalEntryV2> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    public JournalEntryV2 createJournalEntry(JournalEntryV2 journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    public boolean createMultipleJournalEntries(List<JournalEntryV2> entries) {
        journalEntryRepository.saveAll(entries);
        return true;
    }

    public Optional<JournalEntryV2> getJournalById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public JournalEntryV2 updateJournalEntry(JournalEntryV2 journalEntry, ObjectId id) {
        // Find the existing entry by ID
        Optional<JournalEntryV2> optionalOldEntry = journalEntryRepository.findById(id);

        // Check if the entry exists
        if (optionalOldEntry.isPresent()) {
            JournalEntryV2 oldEntry = optionalOldEntry.get();

            // Update the title if it's not null or empty
            if (journalEntry.getTitle() != null && !journalEntry.getTitle().isEmpty()) {
                oldEntry.setTitle(journalEntry.getTitle());
            }

            // Update the content if it's not null or empty
            if (journalEntry.getContent() != null && !journalEntry.getContent().isEmpty()) {
                oldEntry.setContent(journalEntry.getContent());
            }

            // Save and return the updated entry
            return journalEntryRepository.save(oldEntry);
        } else {
            // Return null or throw an exception if the entry is not found
            return null;
        }
    }

    public Optional<JournalEntryV2> deleteJournalById(ObjectId id) {
        Optional<JournalEntryV2> journalEntry = journalEntryRepository.findById(id);
        journalEntry.ifPresent(entry -> journalEntryRepository.delete(entry));
        return journalEntry;
    }

    public boolean deleteAllJournalEntries() {
        try {
            List<JournalEntryV2> allEntries = journalEntryRepository.findAll();
            System.out.println("Found entries: " + allEntries.size()); // Debugging step
            journalEntryRepository.deleteAll();
            System.out.println("All entries deleted successfully."); // Debugging step
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
