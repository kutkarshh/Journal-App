package net.ukumar.journalApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ukumar.journalApp.entities.JournalEntry;
import net.ukumar.journalApp.services.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping
    public JournalEntry createJournalEntry(@RequestBody JournalEntry journalEntry) {
        return journalEntryService.createJournalEntry(journalEntry);
    }

    @PostMapping("/createEntries")
    public Boolean createMultipleJournalEntries(@RequestBody List<JournalEntry> entries) {
        return journalEntryService.createMultipleJournalEntries(entries);
    }

    @GetMapping("id/{id}")
    public JournalEntry getJournalById(@PathVariable Long id) {
        return journalEntryService.getJournalById(id).orElse(null);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntry(@RequestBody JournalEntry journalEntry, @PathVariable Long id) {
        return journalEntryService.updateJournalEntry(journalEntry, id);
    }

    @DeleteMapping("id/{id}")
    public JournalEntry deleteJournalById(@PathVariable Long id) {
        return journalEntryService.deleteJournalById(id).orElse(null);
    }
}
