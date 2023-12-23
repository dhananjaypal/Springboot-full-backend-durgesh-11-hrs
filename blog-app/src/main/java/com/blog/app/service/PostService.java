package com.blog.app.service;

import com.blog.app.entity.Post;
import com.blog.app.payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);

    //search post by keyword
    List<PostDto> searchPosts(String keyword);
}
