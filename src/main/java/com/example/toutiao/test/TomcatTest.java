package com.example.toutiao.test;


import com.example.toutiao.ToutiaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToutiaoApplication.class)
public class TomcatTest {

    @Test
    void path(){

    }
}
