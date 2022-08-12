package com.ll.exam.mysbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpring {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpring(){
        return "Hello Spring!";
    }
}
