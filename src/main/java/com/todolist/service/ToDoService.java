package com.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.model.ToDo;
import com.todolist.repository.IToDoRepo;

@Service
public class ToDoService {

	@Autowired
	IToDoRepo repo;
	
	public List<ToDo> getAllToDoItems() {
		ArrayList<ToDo> todoList = new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}
	
	public ToDo getToDoItemById(Long id) {
		return repo.findById(id).get();
	}
	
	public boolean updateStatus(Long id) {
		ToDo todo = getToDoItemById(id);
		todo.setStatus("Updated");
		return saveOrUpdateToDoItem(todo);
	}

	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updatedObj = repo.save(todo);
        return getToDoItemById(updatedObj.getId()) != null;
    }

	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);
        return repo.findById(id).isEmpty();
    }

}
