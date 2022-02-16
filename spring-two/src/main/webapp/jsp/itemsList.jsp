<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>

</head>
<body>
<h1>图书管理系统</h1>
<form action="${pageContext.request.contextPath}/querybook" method="post">
    <table width="100%" border=1>
        <tr>
            <td>
                按图书类别查询:<select name="categoryId">
                <option value="">不限类型查询</option>
                <c:forEach items="${Name}" var="book">
                    <option value="${book.bookCategory.id}">${book.bookCategory.name}</option>
                </c:forEach>
            </select>
                <input type="submit" value="查找"/>
            </td>
        </tr>
    </table>
</form>
<input type="button" value="添加商品" onclick="javascript:location='${pageContext.request.contextPath}/getName'"/>
<form id="listForm" action="${pageContext.request.contextPath}/items/deleteBatch" method="post">
    <table width="100%" border=1>
        <tr>
            <td>序号</td>
            <td>图书名称</td>
            <td>出版日期</td>
            <td>出版社</td>
            <td>价格</td>
            <td>图书类别</td>
        </tr>
        <c:forEach items="${Book}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td><fmt:formatDate value="${book.publishTime}" pattern="yyyy年MM月dd日"/></td>
                <td>${book.publishName}</td>
                <td>${book.price}</td>
                <td><a href="updateBook?id=${book.id}" style="text-decoration: none">${book.bookCategory.name}</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<div>
    <a href="${pageContext.request.contextPath}/getBook?${Page.firstPage}">首页</a>
    <a href="${pageContext.request.contextPath}/getBook?${Page.prePage}">上一页</a>
    <a href="${pageContext.request.contextPath}/getBook?${Page.nextPage}">下一页</a>
    <a href="${pageContext.request.contextPath}/getBook?${Page.lastPage}">末页</a>
</div>
<div>当前页数:${Page.pageNum} 总记录数:${Page.total} </div>
</body>

</html>