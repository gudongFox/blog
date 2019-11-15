package com.liudong.blog.web.admin;

import com.liudong.blog.po.User;
import com.liudong.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class SignUpController {
    private UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    //跳转到注册页面
    @GetMapping("/signup")
    public String signupPage(){
        return "admin/signup";
    }

    //注册
    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         RedirectAttributes attributes){
        User user = userService.checkUser(username);
        if (user != null){
            attributes.addFlashAttribute("message","用户名" + user.getUsername() + "已被注册");
            return "admin/signup";
        }
        else {
            User user1 = userService.saveUser(username,password);
            attributes.addFlashAttribute("message","用户名" + user1.getUsername() + "注册成功");
            return "admin/login";
        }
    }
}
