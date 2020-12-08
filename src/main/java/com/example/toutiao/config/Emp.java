package com.example.toutiao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Emp {
    @Value("123")
    String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
