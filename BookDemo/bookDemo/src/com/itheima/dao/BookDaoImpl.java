package com.itheima.dao;

import com.itheima.domain.Book;
import com.itheima.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
bookDao的实现类
 */
public class BookDaoImpl implements BookDao {
      /*
      1 查看图书所有信息
      */
    @Override
    public List<Book> FindAll() {
        //创建集合
        List<Book> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            //用jdbc工具类获取数据库连接
            con = JdbcUtils.getConnection();
            //获取执行对象
            stat = con.prepareStatement("select * from book");
            //得到一个结果集
            rs = stat.executeQuery();
            //遍历结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String bookname = rs.getString("bookname");
                String author = rs.getString("author");
                String price = rs.getString("price");
                // 封装学生对象
                Book stu = new Book(bid,bookname,author,price);
                //添加进集合
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.close(rs,stat,con);
        }
        //返回集合
        return list;
    }
    /*
    2  按id查看图书信息
     */
    @Override
    public Book FindById(Integer id) {        //连接数据库
        Connection con = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            //获取对象 预编译Sql语句
            stat = con.prepareStatement("select * from book where bid =?");
            //给?赋值
            stat.setInt(1, id);
            // 执行sql
            rs = stat.executeQuery();
            if (rs.next()) {
                Book stu = new Book();// 查询到数据才创建学生对象
                stu.setBid(rs.getInt("bid"));
                stu.setBookname(rs.getString("bookname"));
                stu.setAuthor(rs.getString("author"));
                stu.setPrice(rs.getString("price"));
                return stu;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(rs, stat, con);
        }
    }
    /*
        3  新增图书信息
    */
    @Override
    public int insert(Book stu) {
        Connection con = null;
        PreparedStatement stat =null;
        try {
            con = JdbcUtils.getConnection();
            stat = con.prepareStatement("insert into  book values (null,?,?,?)");
            stat.setString(1,stu.getBookname());
            stat.setString(2,stu.getAuthor());
            stat.setString(3,stu.getPrice());
            return stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            JdbcUtils.close(stat,con);
        }
    }
    /*
        4 修改图书信息
    */
    @Override
    public int update(Book stu) {
        Connection con = null;
        PreparedStatement stat = null;
        int result =0;
        try {
            con = JdbcUtils.getConnection();
            stat = con.prepareStatement("update book set bookname=?,author=?,price=? where bid=?");
            stat.setString(1,stu.getBookname());
            stat.setString(2,stu.getAuthor());
            stat.setString(3,stu.getPrice());
            stat.setInt(4,stu.getBid());
            //执行sql语句
             result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(stat,con);
        }
        return result;
    }
    /*删除图书信息*/
    @Override
    public int delete(Integer id) {
        Connection con =null;
        PreparedStatement stat =null;
        try {
            con = JdbcUtils.getConnection();
            stat = con.prepareStatement("delete from book where bid = ?");
            stat.setInt(1,id);
            return stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            JdbcUtils.close(stat,con);
        }
    }

    @Override
    public Book Search(Integer id) {
        Connection con = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            //获取对象 预编译Sql语句
            stat = con.prepareStatement("select * from book where bid = ?");
            //给?赋值
            stat.setInt(1, id);
            // 执行sql
            rs = stat.executeQuery();
            if (rs.next()) {
                Book stu = new Book();// 查询到数据才创建学生对象
                stu.setBid(rs.getInt("sid"));
                stu.setBookname(rs.getString("bookname"));
                stu.setAuthor(rs.getString("author"));
                stu.setPrice(rs.getString("price"));
                return stu;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(rs, stat, con);
        }
    }
}
