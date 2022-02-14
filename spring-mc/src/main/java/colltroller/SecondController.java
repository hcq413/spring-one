package colltroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondController {

    @RequestMapping("/java")
    public ModelAndView getshow(){
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("msg","注解开发的api");
       modelAndView.setViewName("index");
       return modelAndView;
    }
}
