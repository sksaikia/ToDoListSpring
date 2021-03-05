package com.example.demo.service;

import com.example.demo.common.ItemNotExistException;
import com.example.demo.dto.ToDoListDTO;
import com.example.demo.model.ToDoList;
import com.example.demo.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository){
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> getAllItems(){
        List<ToDoList> itemList = toDoListRepository.findAll();
        return itemList;
    }

    public void addItem(ToDoListDTO toDoListDTO){
        ToDoList toDoList = getToDoListFromDTO(toDoListDTO);
        toDoListRepository.save(toDoList);
    }

    private ToDoList getToDoListFromDTO(ToDoListDTO toDoListDTO) {
        ToDoList toDoList = new ToDoList(toDoListDTO);
        return toDoList;
    }

    public void deleteItem(int id) throws ItemNotExistException{
        if (!toDoListRepository.existsById(id))
            throw new ItemNotExistException("Item id is invalid : " + id);
        toDoListRepository.deleteById(id);
    }
    public void updateItem(int id,boolean isCompleted) throws ItemNotExistException{
        if (!toDoListRepository.existsById(id))
            throw new ItemNotExistException("Item id is invalid : " + id);
        Optional<ToDoList> optionalToDoList =  toDoListRepository.findById(id);

        ToDoList toDoList =  optionalToDoList.get();
        if (toDoList!=null){
            toDoList.setId(id);
            toDoList.setCompleted(isCompleted);
        }
        toDoListRepository.save(toDoList);

    }


}
