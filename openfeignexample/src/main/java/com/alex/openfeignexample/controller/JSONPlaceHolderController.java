package com.alex.openfeignexample.controller;

import com.alex.openfeignexample.client.JSONPlaceHolderClient;
import com.alex.openfeignexample.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class JSONPlaceHolderController {

    @Autowired
    JSONPlaceHolderClient jsonPlaceHolderClient;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return jsonPlaceHolderClient.getPostById(id);
    }

}
