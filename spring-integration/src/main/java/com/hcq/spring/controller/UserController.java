package com.hcq.spring.controller;


import com.hcq.spring.domain.Auctionuser;
import com.hcq.spring.service_impl.Userimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    Userimpl userimpl;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(String username, String userpassword, String inputCode, Model model, HttpSession httpSession) {

        if (!inputCode.equals(httpSession.getAttribute("numrand"))) {
            model.addAttribute("errormsg", "验证码错误");
            return "login";
        }

        Auctionuser login = userimpl.Login(username, userpassword);
        if (login != null) {
            httpSession.setAttribute("user", login);
            return "index";
        } else {
            model.addAttribute("errormsg", "账号密码错误");
            return "login";
        }

    }
}
