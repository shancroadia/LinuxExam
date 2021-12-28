<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改图书信息</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改图书信息</h3>
    <form action="/UpdateBook" method="post">
        <div class="form-group">
            <input type="text" class="form-control" id="bid" name="bid"  readonly  value="${books.bid}"/>
        </div>

        <div class="form-group">
            <label for="bookname">书名：</label>
            <input type="text" class="form-control" id="bookname" name="bookname"  placeholder="请输入书名" value="${books.bookname}"/>
        </div>

        <div class="form-group">
            <label for="author">作者：</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者" value="${books.author}">
        </div>

        <div class="form-group">
            <label for="price">价格：</label>
            <input type="text" class="form-control" id="price" name="price" placeholder="请输入价格"value="${books.price}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a class="btn btn-default" href="index.jsp">返回</a>
        </div>
    </form>
</div>
</body>
</html>