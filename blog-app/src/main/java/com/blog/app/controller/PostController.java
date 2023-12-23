package com.blog.app.controller;

import com.blog.app.entity.Post;
import com.blog.app.payloads.ApiResponse;
import com.blog.app.payloads.PostDto;
import com.blog.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping("user/{userId}/category/{categoryId}/")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
            ){

        PostDto savedPostDto = this.postService.createPost(postDto, categoryId, userId);
        return new ResponseEntity<>(savedPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("userId") Integer userId){

        List<PostDto> postByUser = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(postByUser,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") Integer categoryId){

        List<PostDto> postByCategory = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postByCategory,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize
            ){
        List<PostDto> allPost = this.postService.getAllPost(pageNumber,pageSize);
        return new ResponseEntity<List<PostDto>>(allPost, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable("postId") Integer postId){
        PostDto post = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ApiResponse deletePost(@PathVariable("postId") Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post deleted successfully !!", true);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer postId){

        PostDto updatedPostDto = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPostDto, HttpStatus.OK);
    }
}
