package com.blog.app.service;

import com.blog.app.payloads.CommentDto;

public interface CommentService {

     CommentDto createComment(CommentDto commentDto, Integer postID);

     void deleteComment(Integer commentId);
}
