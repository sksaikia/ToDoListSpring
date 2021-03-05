package com.example.demo.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.ItemNotExistException;
import com.example.demo.dto.ToDoListDTO;
import com.example.demo.model.ToDoList;
import com.example.demo.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;


    @GetMapping("/")
    public ResponseEntity<List<ToDoList>> getAllItems(){
        List<ToDoList> list =  toDoListService.getAllItems();
        return new ResponseEntity<List<ToDoList>>(list, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> addItem(@RequestBody ToDoListDTO toDoList){
        toDoListService.addItem(toDoList);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Task added to list"),HttpStatus.CREATED);
    }
    @DeleteMapping("/{itemId}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable("itemId") int itemId) throws ItemNotExistException {
        toDoListService.deleteItem(itemId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Task removed from the list"),HttpStatus.CREATED);

    }
    @PutMapping("/{itemId}/{isCompleted}")
    public ResponseEntity<ApiResponse> updateItem(@PathVariable("itemId") int itemId,@PathVariable("isCompleted") boolean isCompleted) throws ItemNotExistException{
        toDoListService.updateItem(itemId, isCompleted);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Item successfully updated"),HttpStatus.OK);
    }
}
