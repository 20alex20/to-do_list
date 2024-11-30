package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.model.ToDo;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, Long> {

}
