package com.test.todo.service;

import com.test.todo.TodoDto;
import com.test.todo.entity.Todo;
import com.test.todo.exception.NotFoundException;
import com.test.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    private static final String TODO_NOT_FOUND_FOR_ID = "Todo not found for id ";

    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }
    public Todo getById(Long id) throws NotFoundException {
        return this.todoRepository.findById(id).orElseThrow(() -> new NotFoundException(TODO_NOT_FOUND_FOR_ID + id));
    }

    public Todo create(TodoDto todoDto) {
        return this.todoRepository.save(new Todo(todoDto.getTitle(), todoDto.getDescription()));
    }

    public Todo update(Long id, TodoDto todoDto) {
        Todo todo = getById(id);
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        return this.todoRepository.save(todo);
    }

    public void delete(Long id) {
        Todo todo = getById(id);
        this.todoRepository.delete(todo);
    }
}
