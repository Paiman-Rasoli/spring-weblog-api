package com.backend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    public List<Post> allPosts(){
        return postRepository.findAll();
    }

    public void create(Post post){
        Optional<Post> findPost = postRepository.findByTitle(post.getTitle());
        if(findPost.isPresent()){
            throw new IllegalStateException("A post with title "+post.getTitle()+" already exist.");
        }
        this.postRepository.save(post);
    }

    public void deleteOne(Integer id){
        this.postRepository.deleteById(id);
    }
}
