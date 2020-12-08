package com.example.toutiao.dao;

import com.example.toutiao.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    static String FIELDS="id,content,type,user_id,entity_id";
    static String INSERT_FIELDS="content,type,user_id,entity_id";
    static String TABLE_NAME="comment";

    @Insert(value = {"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") ","values(#{content},#{type},#{userId},#{entityId})"})
    public void insertComment(Comment comment);

    public List<Comment> getByNewsId(@Param("newsId")int newsId);

    public List<Comment> getCommentAndChildByNewsId(@Param("newsId")int newsId);

    public List<Comment> getByCommentId(@Param("commentId")int commentId);

    public List<Comment> getCommentAndChildByNewsIdJoin(@Param("newsId") int newsId);
}
