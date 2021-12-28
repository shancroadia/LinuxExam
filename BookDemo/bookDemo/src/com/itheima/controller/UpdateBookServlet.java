package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*修改图书信息 Servlet*/
@WebServlet("/UpdateBook")
public class UpdateBookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        Integer bid = Integer.parseInt(req.getParameter("bid"));
        String bookname = req.getParameter("bookname");
        String author = req.getParameter("author");
        String price= req.getParameter("price");
        Book book = new Book(bid,bookname,author,price);
        // 从bookServiceImpl调用update方法
        bookService.update(book);
        //用重定向跳转至表页面地址
        resp.sendRedirect("/FindAllBook");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
