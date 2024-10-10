package net.ukumar.journalApp.entities;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection = "journals")
@Data
public class JournalEntryV2 {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    private LocalDateTime date;

    // // Constructor to set date automatically when an entry is created
    // public JournalEntryV2(String title, String content) {
    // this.title = title;
    // this.content = content;
    // this.date = LocalDateTime.now(); // Automatically set the current date and
    // time
    // }

    // // Getters and Setters
    // public ObjectId getId() {
    // return id;
    // }

    // public void setId(ObjectId id) {
    // this.id = id;
    // }

    // public String getTitle() {
    // return title;
    // }

    // public void setTitle(String title) {
    // this.title = title;
    // }

    // public String getContent() {
    // return content;
    // }

    // public void setContent(String content) {
    // this.content = content;
    // }

    // public LocalDateTime getDate() {
    // return date;
    // }

    // public void setDate(LocalDateTime date) {
    // this.date = date;
    // }
}
