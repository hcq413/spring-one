package com.controller;

import com.domain.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BookCategoryservice;
import com.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 书本控制器
 *
 * @author 黄昌其
 * @date 2022/02/16
 */
@Controller
public class BookController {

    @Autowired
    Bookservice bookservice;
    @Autowired
    BookCategoryservice book;

    @RequestMapping("/getBook")
    public String getBook(Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Book> book = bookservice.getBookAndBook();
        model.addAttribute("Book", book);
        model.addAttribute("Name", bookservice.Groundbybook());
        PageInfo page = new PageInfo<>(book);
        model.addAttribute("Page", page);
        return "itemsList";
    }

    @RequestMapping("/getName")
    public String getName(Model model) {
        model.addAttribute("Name", bookservice.Groundbybook());
        return "toBook";
    }

    @RequestMapping(value = "/bookadd", method = RequestMethod.POST)
    public String bookadd(Book book) {
        bookservice.addBook(book);
        return "redirect:/getBook";
    }

    @RequestMapping(value = "/updateBook")
    public String updateBook(Model model, int id) {
        model.addAttribute("book", bookservice.getBookbyid(id));
        return "toEdit";
    }

    @RequestMapping(value = "/updateBookZhen")
    public String updateBookZhen(Book book) {
        bookservice.updateBook(book);
        return "redirect:/getBook";
    }

    @RequestMapping(value = "/getdelete")
    public String getdelete(int id) {
        Integer delete = bookservice.deleteByPrimaryKey(id);
        if (delete > 0) {
            return "redirect:/getBook";
        }
        return "505";
    }

    @RequestMapping(value = "/querybook")
    public String querybook(Book book, Model model) {
        System.err.println(book.getCategoryId());
        model.addAttribute("Name", bookservice.Groundbybook());
        model.addAttribute("Book", bookservice.getBookbyname(book));
        return "itemsList";
    }
}
