package com.liudong.blog.web;

import com.liudong.blog.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
//        int i = 9 / 0;
        /*String blog = null;
        if (blog == null)
            throw new NotFoundException("页面不存在");*/

        return "index";
    }
}
