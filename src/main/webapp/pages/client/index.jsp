<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <jsp:include page="/pages/Jsp_file/header.jsp"/>
    <script type="text/javascript">

        $(function () {
            $("button.addToCar").click(function () {
                    var id = $(this).attr("bookid");//this代表正在响应的dom对象  attr 是代表获取到当前响应对象的属性值
                    // location.href="http://localhost:8080/guiguBook/carServlet?action=addItem&id="+attr;
                    $.getJSON("http://localhost:8080/guiguBook/carServlet", "action=ajaxAddItem&id=" + id, function (data) {
                        $("#goods").text("您的购物车中有" + data.lastBook + "件商品");
                        $("#count").text("您刚刚将" + data.totalCount + "加入了购物车");
                    })
                }
            )
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <%--如果这个session域中没有值就显示登录和注册--%>
        <c:if test="${empty sessionScope.wolcomeTo}">
            <a href="pages/user/login.jsp">登录${sessionScope.wolcomeTo}</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;
        </c:if>

        <c:if test="${not empty sessionScope.wolcomeTo}">
            <span>欢迎<span class="um_span">${sessionScope.wolcomeTo.username}</span>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="users?action=deleteNow">注销</a>
        </c:if>
        &nbsp;
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>

</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookSer?action=pageByPrice">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <c:if test="${empty sessionScope.ShopCar.itemList}">
            <div style="text-align: center">
                <span id="count"> </span>
                <div>
                    <span style="color: red" id="goods">当前购物车为空</span>
                </div>

            </div>
        </c:if>

        <c:if test="${not empty sessionScope.ShopCar.itemList}">
            <div style="text-align: center">
                    <%--            <span>${sessionScope.ShopCar.totalCount}</span>--%>
                <span id="count"></span>
                    <%--            <span style="color: red">${sessionScope.LastBook} ${sessionScope.ShopCar.itemList.totalCount}</span>--%>
                <div>
<%--                    ${sessionScope.ShopCar.itemList.LastBook}--%>
                    <span style="color: red" id="goods"></span>
                </div>
            </div>
        </c:if>

        <c:forEach items="${requestScope.pages.items}" var="book">

            <div class="b_list">
                <div class="img_div">
                        <%--                    <input type="hidden" name="id" value="${book.id}">--%>
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button class="addToCar" bookid="${book.id}">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <%@ include file="/pages/Jsp_file/page_NextText.jsp" %>
</div>

<%@ include file="/pages/Jsp_file/footer.jsp" %>
</body>
</html>