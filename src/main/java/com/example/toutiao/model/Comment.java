package com.example.toutiao.model;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("comment")
public class Comment {

    private int id;
    private String content;
    private int type; //0表示news得评论 1 表示comment得评论
    private int entityId; //表示这个是哪个news或comment得评论
    private int userId;
    private List<Comment> childComments;

    public List<Comment> getChildComments() {
        return childComments;
    }

    public Comment setChildComments(List<Comment> childComments) {
        this.childComments = childComments;
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", entityId=" + entityId +
                ", userId=" + userId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Comment setType(int type) {
        this.type = type;
        return this;
    }

    public int getId() {
        return id;
    }

    public Comment setId(int id) {
        this.id = id;
        return this;
    }



    public int getType() {
        return type;
    }


    public int getEntityId() {
        return entityId;
    }

    public Comment setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Comment setUserId(int userId) {
        this.userId = userId;
        return this;
    }
}
