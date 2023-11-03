package com.todos.controller;

import com.todos.model.Todo;
import com.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final RestTemplate restTemplate;
    private final TodoRepository todoRepository;
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        Todo[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos",
                Todo[].class);
        List<Todo> postList = Arrays.asList(posts);
        postList.stream().forEach(post -> {
            if(!Objects.isNull(postList)) {
                post.setCompleted(true);
            }
            post.setInsertDate(LocalDateTime.now());
            todoRepository.save(post);
        });
        return postList;
    }

    @GetMapping("/todos/completed")
    public List<Todo> getCompletedPosts() {
        return todoRepository.findByCompleted(true);
    }
    @PostMapping("/todos")
    public Todo saveTodos(@RequestBody Todo post) {
        post.setInsertDate(LocalDateTime.now());
        return todoRepository.save(post);
    }
}
