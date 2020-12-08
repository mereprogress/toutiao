package com.example.toutiao.controller;

import com.example.toutiao.ToutiaoApplication;
import com.example.toutiao.component.MyJSON;
import com.example.toutiao.model.Comment;
import com.example.toutiao.model.HostUser;
import com.example.toutiao.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    HostUser hostUser;

    private static final Logger logger= LoggerFactory.getLogger(ToutiaoApplication.class);

    @ResponseBody
    @PostMapping("/news")
    Object newsComment(@RequestBody Comment comment){


        try {
            if(comment.getUserId()==0&&hostUser.getUser()!=null){
                comment.setUserId(hostUser.getUser().getId());
            }
            comment.setType(0);
            if(comment.getContent()==null||comment.getContent().equals("")){
                throw new Exception("评论不为空");
            }
            if(comment.getUserId()==0){
                throw new Exception("用户为空");
            }
            commentService.updateCount(comment);
        }catch (Exception e){
            logger.error("评论失败"+e.getMessage());
            return MyJSON.getJSON(0,"评论失败:  "+e.getMessage());
        }
        return MyJSON.getJSON(1,"评论成功");
    }

    @ResponseBody
    @PostMapping("/comment")
    Object commentComment(@RequestBody Comment comment){


        try {
            comment.setType(1);
            commentService.updateCount(comment);
        }catch (Exception e){
            logger.error("评论失败"+e.getMessage());
            return MyJSON.getJSON(0,"评论失败");
        }
        return MyJSON.getJSON(1,"评论成功");
    }
}
