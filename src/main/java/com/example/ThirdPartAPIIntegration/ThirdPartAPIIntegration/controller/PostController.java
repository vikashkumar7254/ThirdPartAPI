package com.example.ThirdPartAPIIntegration.ThirdPartAPIIntegration.controller;

import com.example.ThirdPartAPIIntegration.ThirdPartAPIIntegration.postservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/getPosts")
    List<Map<String ,Object>>getAllPosts(){
        return postService.getPosts();

    }
    @GetMapping("/getPostsById/{id}")
    Map<String ,Object>getAllPosts(@PathVariable int id){
        return postService.getPostById(id);

    }
}
