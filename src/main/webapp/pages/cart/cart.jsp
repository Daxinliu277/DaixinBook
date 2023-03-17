<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <jsp:include page="/pages/Jsp_file/header.jsp"/>
    <script type="text/javascript">
        $(function () {
            $("a.del").click(function () {
                return confirm("是否要删除这个商品:" + $(this).parent().parent().find("td:first").text())
            });
            $("a.clearAll").click(function () {
                return confirm("是否要删除这个商品清除所有商品？")
            });
            $(".Count").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;//现在正在响应的value值
                var bookid =$(this).attr("bookid")
                // var bookid = this.attr("bookid")

                if (confirm("是否将这个" + name + "的数量修改为" + count)) {
                    location.href = "http://localhost:8080/guiguBook/carServlet?action=UpdateValue&id=" + bookid + "&count=" + count
                } else {
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>

<jsp:include page="/pages/Jsp_file/menu.jsp"/>
<div id="main">
    ${sessionScope.ShopCar}
    ${requestScope}

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.ShopCar.itemList}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前未添加商品</a></td>
            </tr>
        </c:if>


        <c:if test="${not empty sessionScope.ShopCar.itemList}">
            <c:forEach items="${sessionScope.ShopCar.itemList}" var="items">
                <tr>
                        <%--                    <input type="hidden" name="id" value="${items.value.id}">--%>
                    <td>${items.value.name}</td>
                    <td>
                        <input type="text" style="width: 55px" class="Count" value=" ${items.value.count}"
                               bookid="${items.value.id}">
                    </td>
                    <td>${items.value.price}</td>
                    <td>${items.value.totalPrice}</td>
                    <td><a href="carServlet?action=delete&id=${items.value.id}" class="del">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <c:if test="${not empty sessionScope.ShopCar.itemList}" var="a">
        <div class="cart_info">

            <span class="cart_span">购物车中共有<span
                    class="b_count">${sessionScope.ShopCar.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.ShopCar.totalPrice}</span>元</span>
            <span class="cart_span"><a href="carServlet?action=clearShopCar" class="clearAll">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</div>

<%@ include file="/pages/Jsp_file/footer.jsp" %>
</body>
</html>