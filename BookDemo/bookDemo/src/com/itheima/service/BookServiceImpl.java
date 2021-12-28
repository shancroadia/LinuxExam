package com.itheima.service;

import com.itheima.dao.BookDao;
import com.itheima.dao.BookDaoImpl;
import com.itheima.domain.Book;

import java.util.List;

/*
BookServiceImpl的实现类
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    //1 查看图书所有信息
    @Override
    public List<Book> FindAll() {
        return bookDao.FindAll();
    }
    // 2 按照id查询图书信息
    @Override
    public Book FindById(Integer id) {
        return bookDao.FindById(id);
    }
    // 3 新增
    @Override
    public int insert(Book stu) {
        return bookDao.insert(stu);
    }
    //4 修改图书信息
    @Override
    public int update(Book stu) {
        return bookDao.update(stu);
    }
    //5 删除
    @Override
    public int delete(Integer id) {
        return bookDao.delete(id);
    }
    //6 查询
    @Override
    public Book Search(Integer id) {
        return bookDao.Search(id);
    }
}
