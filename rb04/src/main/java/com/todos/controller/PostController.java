package com.todos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final RestTemplate restTemplate;
    private final PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        Post[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos",
                Post[].class);
        List<Post> postList = Arrays.asList(posts);
        postList.stream().forEach(post -> {
            if(!Objects.isNull(postList)) {
                post.setCompleted(true);
            }
            post.setInsertDate(LocalDateTime.now());
            postRepository.save(post);
        });
        return postList;
    }

    @GetMapping("/posts/completed")
    public List<Post> getCompletedPosts() {
        return postRepository.findByCompleted(true);
    }
    @PostMapping("/posts")
    public Post savePost(@RequestBody Post post) {
        post.setInsertDate(LocalDateTime.now());
        return postRepository.save(post);
    }
}