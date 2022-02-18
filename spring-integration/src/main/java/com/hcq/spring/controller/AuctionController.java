package com.hcq.spring.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcq.spring.domain.Auction;
import com.hcq.spring.service_impl.Auctionimpl;
import com.hcq.spring.utils.Myutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;

@Controller
public class AuctionController {

    @Autowired
    Auctionimpl auctionimpl;

    public static final int PAGE_SIZE = 5;

    @RequestMapping("/queryAutions")
    public ModelAndView queryAutions(@RequestParam(defaultValue = "1") int pageNum,
                                     @ModelAttribute("condition") Auction auction) {
        Myutils.printlnErr("当前页数" + pageNum);
        PageHelper.startPage(pageNum, PAGE_SIZE);
        ArrayList<Auction> actions = auctionimpl.getAllActions(auction);
        PageInfo<Auction> info = new PageInfo<>(actions);
        ModelAndView andView = new ModelAndView();
        andView.addObject("auctionList", actions);
        andView.addObject("Page", info);
        andView.setViewName("index");

        return andView;
    }

    @RequestMapping(value = "/publishAuctions", method = RequestMethod.POST)
    public String publishAuctions(Auction auction, MultipartFile pic, HttpSession session) {
        try {
            if (pic.getSize() > 0) {
                String page = session.getServletContext().getRealPath("upload");
                Myutils.printlnErr(page);
                File file = new File(page, pic.getOriginalFilename());

                pic.transferTo(file);

                //设置不能为null的参数

                auction.setAuctionpic(pic.getOriginalFilename());
                auction.setAuctionpictype(pic.getContentType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        auctionimpl.addAction(auction);
        return "redirect:/queryAutions";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("auction", auctionimpl.selectByid(id));
        mv.setViewName("updateAuction");
        return mv;
    }

}
