package models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Comment {
    private String author;
    private String text;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @PostConstruct
    public void init() {
        this.author = "Wearing";
        this.text = "Sample Comment";
    }
}
