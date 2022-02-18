<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/WebCalendar.js"></script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="${pageContext.request.contextPath}/doLoginout" title="注销">注销</a></div>
    </div>
    <div class="forms">
        <form action="${pageContext.request.contextPath}/queryAutions" method="post" id="from_query">
            <input id="page" name="pageNum" type="hidden" value="1"/>
            <label for="name">名称</label>
            <input name="auctionname" type="text" class="nwinput" id="name" value="${condition.auctionname}"/>
            <label for="names">描述</label>
            <input name="auctiondesc" type="text" id="names" class="nwinput" value="${condition.auctiondesc}"/>
            <label for="time">开始时间</label>
            <input name="auctionstarttime" value="${condition.auctionstarttime}" type="text" id="time" class="nwinput"
                   onclick="selectDate(this,'yyyy-MM-dd hh:mm:ss')"/>
            <label for="end-time">结束时间</label>
            <input name="auctionendtime" value="${condition.auctionendtime}" type="text" id="end-time" class="nwinput"
                   onclick="selectDate(this,'yyyy-MM-dd hh:mm:ss')"/>
            <label for="price">起拍价</label>
            <input name="auctionstartprice" value="${condition.auctionstartprice}" type="text" id="price"
                   class="nwinput"/>
            <c:if test="${sessionScope.user.userisadmin==1}">
                <input type="submit" value="查询"/>
            </c:if>
            <c:if test="${sessionScope.user.userisadmin==1}">
                <input type="button" value="发布" class="spbg buttombg f14  sale-buttom buttomb"
                       onclick='location.href=("${pageContext.request.contextPath}/addAuction.jsp")'
                />
            </c:if>

        </form>


    </div>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>
        <c:forEach items="${auctionList}" var="aution" varStatus="index">
            <ul
                    <c:if test="${index.index%2!=0}">class="rows"</c:if>
                    <c:if test="${index.index%2==0}">class="rows even"</c:if>
            >
                <li>${aution.auctionname}</li>
                <li class="list-wd">${aution.auctiondesc}</li>
                <li>
                    <fmt:formatDate value="${aution.auctionstarttime}" pattern="yyyy-MM-dd  hh:mm:ss"/>
                </li>
                <li>
                    <fmt:formatDate value="${aution.auctionendtime}" pattern="yyyy-MM-dd  hh:mm:ss"/>
                </li>
                <li>${aution.auctionstartprice}</li>
                <li class="borderno red">
                    <c:if test="${sessionScope.user.userisadmin==1}">
                        <a href="${pageContext.request.contextPath}/update/${aution.auctionid}" title="竞拍" onclick="dele();">修改</a>|
                    </c:if>

                    <c:if test="${sessionScope.user.userisadmin==1}">
                        <a href="#" title="竞拍" onclick="abc();">删除</a>
                    </c:if>
                    <c:if test="${sessionScope.user.userisadmin==0}">
                        <a href="#" title="竞拍" onclick="abc();">竞拍</a>
                    </c:if>
                </li>
            </ul>
        </c:forEach>
        <div class="page">
            [当前第${Page.pageNum}页 总共${Page.pages}页, 总共${Page.total}]
            <a href="javascript:jumPage(1)">首页</a>
            <a href="javascript:jumPage(${Page.prePage})">上一页</a>
            <a href="javascript:jumPage(${Page.nextPage})">下一页</a>
            <a href="javascript:jumPage(${Page.pages})">尾页</a>
        </div>
    </div>
    <script>
        function jumPage(page_num) {
            document.getElementById("page").value = page_num
            document.getElementById("from_query").submit();
        }
    </script>
</div>
</body>
</html>
