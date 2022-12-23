package com.backend.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
            String body
    )
    {}
    @GetMapping
    public List<Post> index(){
        return postService.allPosts();
    }

    @PostMapping
    public void create(@RequestBody CreatePostBody request){
        Post post = new Post();
        post.setTitle(request.title());
        post.setBody(request.body());
        this.postService.create(post);
    }
    record Response(Boolean deleted){public Response(Boolean deleted){this.deleted = deleted;}}
    @DeleteMapping("{postId}")
    public Response deletePost(@PathVariable("postId") Integer id){
        try{
            this.postService.deleteOne(id);
            return new Response(true);
        }catch (Exception e){
            System.out.println(e);
            return new Response(false);
        }
    }

//    @PutMapping

}
