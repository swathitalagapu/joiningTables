package com.example.joiningTables.service;

import com.example.joiningTables.dto.PostResponse;
import com.example.joiningTables.entity.Post;
import com.example.joiningTables.entity.User;
import com.example.joiningTables.exception.DataNotFoundException;
import com.example.joiningTables.repository.PostRepository;
import com.example.joiningTables.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PostService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    public Optional<Post> createPost(int userId, Post post){
       Optional<Post> post1 = userRepository.findById(userId).map(user -> {
//            post.setUser(user);
            return postRepository.save(post);
        });
        return post1;

    }

//    public List<Post> getAllPostsByUserId(int userId){
//        if(!userRepository.existsById(userId)){
//            throw new DataNotFoundException("no data found");
//        }
//        List<Post> posts = postRepository.findByUserId(userId);
//        return posts;
//    }
public List<Post> getAllPosts(){
    return postRepository.findAll();
}
    public Post getPostById(int id){

        return postRepository.findById(id).orElse(null);
    }

    public Post updatePost(int id, Post post){
        Post pst = postRepository.findById(post.getId()).orElse(null);
              pst.setId(post.getId());
              pst.setTitle(post.getTitle());
              pst.setBody(post.getBody());
              Post updatedPost = postRepository.save(pst);
              return updatedPost;
    }


    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    public List<PostResponse> getPostInformation() {
        return postRepository.getPostInformation();
    }

    public PostResponse getPostsById(int id){
        return postRepository.getPostById(id);
    }
}