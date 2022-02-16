<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书入库</title>
</head>
<body>
<form action="bookadd" method="post">
    <p>
        图书类型:
        <select name="categoryId">
            <c:forEach items="${Name}" var="bookname">
                <option value="${bookname.bookCategory.id}">
                        ${bookname.bookCategory.name}
                </option>
            </c:forEach>
        </select>
    </p>
    <p>图书名称: <input type="text" name="name"></p>
    <p>出版日期: <input type="date" name="publishTime"></p> (格式:yyyy-MM-dd)
    <p>价格: <input type="text" name="price"></p>
    <p>出版社 :<input type="text" name="publishName"></p>
    <p></p>
    <input type="submit" value="保 存">
    <input type="reset" value="重置">
    <input type="button" value="返回" onclick="location='${pageContext.request.contextPath}/getBook'"/>
</form>
<input type="button" value="首页" onclick="location='${pageContext.request.contextPath}/getBook'"/>
</body>
</html>
