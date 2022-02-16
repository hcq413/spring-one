<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书编辑</title>
</head>
<body>
<h1>修改图书信息</h1>
<form action="updateBookZhen" method="post">
    <input type="hidden" name="id" value="${book.id}">
    图书类型:
    <select name="categoryId">
        <option
                <c:if test="${book.categoryId==1}">selected</c:if> value="1">经济
        </option>
        <option
                <c:if test="${book.categoryId==2}">selected</c:if> value="2">军事
        </option>
        <option
                <c:if test="${book.categoryId==3}">selected</c:if> value="3">工业
        </option>
    </select>
    <p>图书名称: <input type="text" name="name" value="${book.name}"/></p>
    <p>出版日期: <input type="text" name="publishTime"
                    value="<fmt:formatDate value="${book.publishTime}" pattern="yyyy年MM月dd日"/>"/></p> (格式:yyyy-MM-dd)
    <p>价格: <input type="text" name="price" value="${book.price}"/></p>
    <p>出版社 :<input type="text" name="publishName" value="${book.publishName}"/></p>
    <p>出版日期 <input type="text" name="selfTime"
                   value="<fmt:formatDate value="${book.selfTime}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/>"/></p>
    <p>
        <input type="submit" value="更 新">
        <input type="button" value="返回" onclick="location='${pageContext.request.contextPath}/getBook'"/>
        <input type="button" value="删除"
               onclick="location='${pageContext.request.contextPath}/getdelete?id=${book.id}'"/>
    </p>
</form>
</body>
</html>
