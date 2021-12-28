package com.itheima.dao;
import com.itheima.domain.Book;
import java.util.List;

/*BookDao接口*/
public interface BookDao {
    //1 查看图书所有信息
    public abstract List<Book> FindAll();

    //2 按id查看图书信息
    public abstract Book FindById(Integer id);

    //3 新增图书信息
    public abstract int insert(Book stu);

    //4 修改图书信息
    public abstract int update(Book stu);

    //5 删除图书信息
    public abstract int delete(Integer id);

    //6 查询图书信息
    public abstract Book Search(Integer id);
}
