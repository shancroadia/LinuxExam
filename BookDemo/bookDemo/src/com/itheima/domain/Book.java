package com.itheima.domain;
import java.util.Date;
/*图书类*/
public class Book {
    private Integer bid;
    private String bookname;
    private String author;
    private String price;

    public Book() {
    }

    public Book(Integer bid, String bookname, String author, String price) {
        this.bid = bid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Student{" +
                "bid=" + bid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
