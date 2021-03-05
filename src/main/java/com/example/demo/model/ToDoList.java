package com.example.demo.model;

import com.example.demo.dto.ToDoListDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="todolist")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="is_completed")
    private Boolean isCompleted;

    @Column(name="created_at")
    private Date createdAt;

    public ToDoList() {
    }

    public ToDoList(Integer id, String title, String description, Boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.createdAt = new Date();
    }
    public ToDoList(ToDoListDTO toDoListDTO){
        this.id = toDoListDTO.getId();
        this.title = toDoListDTO.getTitle();
        this.description = toDoListDTO.getDescription();
        this.createdAt = new Date();
        this.isCompleted = toDoListDTO.getCompleted();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
