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

/*按id查询图书信息 Servlet*/
@WebServlet("/FindByIdBook")
public class FindByIdBookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String bid = req.getParameter("bid");
        // 从bookServiceImpl调用FindById方法 获取数据
        Book books = bookService.FindById(Integer.parseInt(bid));
        // 将数据存入请求域
         req.setAttribute("books",books);
        // 转发至jsp页面显示
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
