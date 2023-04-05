package com.test.todo.controller;

import com.sun.xml.bind.v2.TODO;
import com.test.todo.TodoDto;
import com.test.todo.entity.Todo;
import com.test.todo.exception.NotFoundException;
import com.test.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Tag(name = "Todo api")
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final ModelMapper modelMapper;

    private final TodoService todoService;

    @Operation(summary = "Create todo")
    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto todoDto) {
        log.info("Post todo");
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(todoService.create(todoDto), TodoDto.class));
    }

    @Operation(summary = "Update existing todo")
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long id, @Valid @RequestBody TodoDto todoDto)
            throws NotFoundException {
        log.info("Put todo (id:{})", id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(this.todoService.update(id, todoDto), TodoDto.class));
    }

    @Operation(summary = "Get All todo")
    @GetMapping()
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.todoService.getAll());
    }

    @Operation(summary = "Get details todo")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getDetailsTodo(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(this.todoService.getById(id), TodoDto.class));
    }

}
