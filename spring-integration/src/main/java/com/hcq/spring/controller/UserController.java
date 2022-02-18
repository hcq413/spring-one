package com.hcq.spring.controller;


import com.hcq.spring.domain.Auctionuser;
import com.hcq.spring.service_impl.Userimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    Userimpl userimpl;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(String username, String userpassword, String inputCode, Model model, HttpSession Session) {

        if (!inputCode.equals(Session.getAttribute("numrand"))) {
            model.addAttribute("errormsg", "验证码错误");
            return "login";
        }

        Auctionuser login = userimpl.Login(username, userpassword);
        if (login != null) {
            Session.setAttribute("user", login);
            return "redirect:/queryAutions";
        } else {
            model.addAttribute("errormsg", "账号密码错误");
            return "login";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model,
                           @ModelAttribute("registerUser") @Validated Auctionuser auctionuser, BindingResult bing) {
        if (bing.hasErrors()) {
            bing.getFieldErrors().forEach(e ->
                    model.addAttribute(e.getField(), e.getDefaultMessage()));
            return "register";
        }
        userimpl.UserRegistered(auctionuser);
        return "login";
    }

    @RequestMapping("/doLoginout")
    public String doLoginout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
}
