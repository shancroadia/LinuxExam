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

@WebServlet("/InsertBook")
public class InsertBookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        String bookname = req.getParameter("bookname");
        String author = req.getParameter("author");
        String price= req.getParameter("price");
        Book book = new Book(null,bookname,author,price);
        // 从bookServiceImpl调用insert方法
        bookService.insert(book);
        //用重定向跳转至表页面地址
        resp.sendRedirect("/FindAllBook");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
