package com.example.toutiao.info;

import com.example.toutiao.model.group.NewsUser;

import java.util.Date;
import java.util.List;

public class NewsUsers {
    private Date date;
    private List<NewsUser> newsUserList;

    @Override
    public String toString() {
        return "NewsUsers{" +
                "newsUserList=" + newsUserList +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<NewsUser> getNewsUserList() {
        return newsUserList;
    }

    public void setNewsUserList(List<NewsUser> newsUserList) {
        this.newsUserList = newsUserList;
    }


}
