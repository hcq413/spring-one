package com.hcq.spring.Interceptor;

import com.hcq.spring.utils.Myutils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        Myutils.printlnErr("当前uri"+uri);
        if (uri.contains("doLogin") || uri.contains("register")) {
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") != null) {
            System.err.println("进来了吗");
            return true;
        } else {
            httpServletResponse.sendRedirect("login.jsp");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
