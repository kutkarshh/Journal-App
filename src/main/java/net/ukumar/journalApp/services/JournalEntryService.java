package net.ukumar.journalApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.ukumar.journalApp.entities.JournalEntry;
import net.ukumar.journalApp.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry createJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    public boolean createMultipleJournalEntries(List<JournalEntry> entries) {
        journalEntryRepository.saveAll(entries);
        return true;
    }

    public Optional<JournalEntry> getJournalById(Long id) {
        return journalEntryRepository.findById(id);
    }

    public JournalEntry updateJournalEntry(JournalEntry journalEntry, Long id) {
        journalEntry.setId(id); // Ensure the ID is set for the update
        return journalEntryRepository.save(journalEntry);
    }

    public Optional<JournalEntry> deleteJournalById(Long id) {
        Optional<JournalEntry> journalEntry = journalEntryRepository.findById(id);
        journalEntry.ifPresent(entry -> journalEntryRepository.delete(entry));
        return journalEntry;
    }
}
