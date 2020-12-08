package com.example.toutiao.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("message")
public class Message {
    private int id; //唯一标识
    private int fromId; //发出者
    private int toId; //接受者
    private String content; //内容
    private Date createdDate; //创建时间
    private int hasRead; //有没有读
    private String conversationId; //会话 通过会话查询 两个人的全部对话 外键

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", hasRead=" + hasRead +
                ", conversationId='" + conversationId + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public int getFromId() {
        return fromId;
    }

    public Message setFromId(int fromId) {
        this.fromId = fromId;
        return this;
    }

    public int getToId() {
        return toId;
    }

    public Message setToId(int toId) {
        this.toId = toId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Message setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public int getHasRead() {
        return hasRead;
    }

    public Message setHasRead(int hasRead) {
        this.hasRead = hasRead;
        return this;
    }

    public String getConversationId() {
        return conversationId;
    }

    public Message setConversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }
}
