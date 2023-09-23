package cn.esuny.super_cube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("index")
public class login {
    @RequestMapping("/login")
    public String index(){
        return "hello world";
    }

}
