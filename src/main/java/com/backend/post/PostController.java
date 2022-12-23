package com.backend.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
    // Records
    record CreatePostBody(
            String title,

            @JsonFormat(
                    shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
            )
            Date created
    ){

    }
    @GetMapping
    public List<Post> index(){
        return postService.allPosts();
    }

    @PostMapping
    public void create(@RequestBody CreatePostBody request){
        Post post = new Post();
        post.setTitle(request.title());
        post.setCreatedAt("2022-12-02");
        this.postService.create(post);
    }
}
