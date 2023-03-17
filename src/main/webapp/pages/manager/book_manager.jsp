<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <jsp:include page="/pages/Jsp_file/header.jsp"/>
    <script>

        $(function () {

            $("a.delete").click(function () {

                return confirm("确定要删除" + $(this).parent().parent().find("td:first").text() + "的数据吗？")

            });

        });

    </script>


</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@ include file="/pages/Jsp_file/Manager_jsp.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <tr>

            <c:forEach items="${requestScope.pages.items}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.sales}</td>
            <td>${book.stock}</td>

            <td>
                <a href="${requestScope.pages.url}=getBook&id=${book.id}&method=update&PageNo=${requestScope.pages.pageNo}">修改</a>
            </td>
                <%--这里的${Book.ID}就类似于post请求上面的那个值  可以通过getparmeter获取--%>
            <td><a class="delete"
                   href="${requestScope.pages.url}=delete&id=${book.id}&PageNo=${requestScope.pages.pageNo}">删除</a></td>
        </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=add&PageNo=${requestScope.pages.pageTotal}">添加图书</a>
            </td>
        </tr>
    </table>

    <%@ include file="/pages/Jsp_file/page_NextText.jsp"%>
</div>

<%@ include file="/pages/Jsp_file/footer.jsp" %>
</body>
</html>