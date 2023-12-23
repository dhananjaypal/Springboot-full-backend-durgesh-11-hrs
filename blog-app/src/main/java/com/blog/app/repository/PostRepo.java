package com.blog.app.repository;

import com.blog.app.entity.Category;
import com.blog.app.entity.Post;
import com.blog.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
