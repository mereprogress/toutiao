package com.example.toutiao.service;


import com.example.toutiao.dao.CommentDao;
import com.example.toutiao.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;

    public void updateCount(Comment comment) {
        commentDao.insertComment(comment);
    }
}
