package com.ll.exam.mysbb;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class HelloSpring {

    @RequestMapping("/hello")

    public String helloSpring(){
        return "likebutton";
    }
}
