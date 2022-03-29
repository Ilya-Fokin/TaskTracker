package com.netcracker.Domains;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Comment")
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();

    @Column(name = "content")
    private String content;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_task")
    private Task task;

    public Comment() {}

    public Comment(String content, LocalDateTime dateTime, User sender, Task task) {
        this.content = content;
        this.dateTime = dateTime;
        this.sender = sender;
        this.task = task;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getSender() {
        return sender;
    }

    public Task getTask() {
        return task;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
