package com.example.toutiao.model.group;

import com.example.toutiao.model.News;
import com.example.toutiao.model.User;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

@Alias(value = "newsUser")
public class NewsUser {
    private News news;
    private User user;

    @Override
    public String toString() {
        return "NewsUser{" +
                "news=" + news +
                ", user=" + user +
                '}';
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
