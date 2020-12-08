package com.example.toutiao.service;

import com.example.toutiao.dao.TicketDao;
import com.example.toutiao.dao.UserDao;
import com.example.toutiao.model.Ticket;
import com.example.toutiao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketDao ticketDao;

    @Autowired
    UserDao userDao;

    public Ticket updateCount(int userId) {
        Ticket ticket = new Ticket();
        Calendar calendar=Calendar.getInstance();//单例
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR,1);
        ticket.setExpire(calendar.getTime());
        ticket.setUserId(userId);
        ticket.setStatus(1);
        ticket.setTicket(String.valueOf(UUID.randomUUID().toString().hashCode()));
        ticketDao.Insert(ticket);
        return ticket;

    }



    public User getUser(String ticket) {
        Ticket ticket1 = ticketDao.getTicket(ticket);
        return userDao.getById(ticket1.getUserId());
    }
}
