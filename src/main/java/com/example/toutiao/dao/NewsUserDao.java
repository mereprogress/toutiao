package com.example.toutiao.dao;

import com.example.toutiao.model.group.NewsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface NewsUserDao {
    static String FIELDS="id,";

    List<NewsUser> getPart(@Param(value = "offset") int offset, @Param(value = "length") int length);

    @Select("select count(*) from news")
    Integer getCount();

    @Update("update from news ")
    void updateLike(int newsId, Long size);
}
