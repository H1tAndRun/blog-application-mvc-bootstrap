package com.example.blog.service;

import com.example.blog.handler.BlogException;
import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService {

    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllPost(){
       return postRepository.findAll();
    }

    public void createPost(Post post){
        postRepository.save(post);
    }

    public Post findById(Integer id){
        return postRepository.findById(id).orElseThrow(BlogException::new);
    }

    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }
}
