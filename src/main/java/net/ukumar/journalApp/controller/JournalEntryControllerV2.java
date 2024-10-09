package net.ukumar.journalApp.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ukumar.journalApp.entities.JournalEntryV2;
import net.ukumar.journalApp.services.JournalEntryServiceV2;

@RestController
@RequestMapping("/journalv2")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryServiceV2 journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntryV2>> getAllJournalEntries() {
        List<JournalEntryV2> entries = journalEntryService.getAllJournalEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JournalEntryV2> createJournalEntry(@RequestBody JournalEntryV2 journalEntry) {

        try {
            JournalEntryV2 createdEntry = journalEntryService.createJournalEntry(journalEntry);
            if (createdEntry != null) {
                return new ResponseEntity<>(createdEntry, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;

    }

    @PostMapping("/createEntries")
    public ResponseEntity<Boolean> createMultipleJournalEntries(@RequestBody List<JournalEntryV2> entries) {
        boolean success = journalEntryService.createMultipleJournalEntries(entries);
        return success ? new ResponseEntity<>(success, HttpStatus.CREATED)
                : new ResponseEntity<>(success, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JournalEntryV2> getJournalById(@PathVariable ObjectId id) {
        Optional<JournalEntryV2> journal = journalEntryService.getJournalById(id);

        if (journal.isPresent()) {
            return new ResponseEntity<>(journal.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<JournalEntryV2> updateJournalEntry(@RequestBody JournalEntryV2 journalEntry,
            @PathVariable ObjectId id) {
        JournalEntryV2 updatedEntry = journalEntryService.updateJournalEntry(journalEntry, id);
        if (updatedEntry != null) {
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId id) {
        Optional<JournalEntryV2> deletedEntry = journalEntryService.deleteJournalById(id);
        if (deletedEntry.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllJournalEntries() {
        boolean success = journalEntryService.deleteAllJournalEntries();
        return success ? new ResponseEntity<>(success, HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(success, HttpStatus.BAD_REQUEST);
    }
}
