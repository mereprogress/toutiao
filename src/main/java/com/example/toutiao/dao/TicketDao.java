package com.example.toutiao.dao;

import com.example.toutiao.model.Ticket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao {
    String INSERT_FIELDS=" user_id,ticket,expire,status ";
    String TABLE_NAME=" ticket ";
    String IPDATE_FIELDS=" user_id=#{userId},ticket=#{ticket},expire=#{expire},status=#{status} ";
    String SELECT_FIELDS="id,user_id,ticket,expire,status";

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert(value = {"insert into ticket(",INSERT_FIELDS,")"," values(#{userId},#{ticket},#{expire},#{status}) "})
    void Insert(Ticket ticket);

    @Select(value = {"select ",SELECT_FIELDS,"from",TABLE_NAME,"where ticket=#{ticket}"})
    Ticket getTicket(String ticket);
}
