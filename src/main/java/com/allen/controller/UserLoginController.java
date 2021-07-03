package com.allen.controller;

import com.allen.pojo.User;
import com.allen.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Allen
 * @date 2021/6/15 14:45
 */

@Controller
public class UserLoginController {

    @Autowired
    UserLoginService service;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

//    @RequestMapping("/LoginSuccess")
//    public String LoginSuccess(Model model, User user){
//        //先查询看该用户名是否存在
//        User userLogin1 = service.queryByName(user.getUsername());
//        if(userLogin1 != null){ //  如果查询的用户不为空
//            System.out.println(userLogin1.toString());
//            return "index";   //登陆成功后，可重定向到首页
//        }
//        else{
//            //返回到注册页面
//            model.addAttribute("data","该用户不存在，请先注册");
//            return "register";
//        }
//    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                        Model model, HttpServletRequest request) {
        User user = service.queryByName(username);

        if(user != null){       //  如果查询的用户不为空
            String pwd = user.getPassword();
            if (password.equals(pwd)) {         //验证密码
                model.addAttribute("user", user);
                request.getSession().setAttribute("user", user);
                System.out.println(user.toString());
                return "redirect:/index";
            } else {
                model.addAttribute("data","密码错误，请重试");
                return "login"; //      ?????? redirect or send ??????
            }
        }
        else{
            //返回到注册页面
            model.addAttribute("data","该用户不存在，请先注册");
            return "login";
        }
    }

    //注册界面
    @RequestMapping(value = {"/toRegister"}, method = RequestMethod.POST)
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/RegisterSuccess")
    public String toRegisterSuccess(Model model, User user){
        if(service.queryByName(user.getUsername())!=null){
            model.addAttribute("msg","用户名已存在，请换一个用户名试试");
            return "register";
        }else{
            //将账号密码加入到数据库中
            service.add(user);
            System.out.println("数据插入成功！");
            model.addAttribute("data","注册成功，请登录！");
            return "login";
        }
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }

}
