package com.example.demo.dto;

import com.example.demo.model.ToDoList;
import com.sun.istack.NotNull;

public class ToDoListDTO {
    
    private Integer id;
    private @NotNull String title;
    private @NotNull String description;
    private @NotNull Boolean isCompleted;

    public ToDoListDTO(ToDoList toDoList) {
        this.setId(toDoList.getId());
        this.setTitle(toDoList.getTitle());
        this.setDescription(toDoList.getDescription());
        this.setCompleted(toDoList.getCompleted());
    }

    public ToDoListDTO() {
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
}
