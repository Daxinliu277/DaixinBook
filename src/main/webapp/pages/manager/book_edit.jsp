<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <jsp:include page="/pages/Jsp_file/header.jsp"/>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">编辑图书</span>
    <%@ include file="/pages/Jsp_file/Manager_jsp.jsp" %>
</div>

<div id="main">
    <form action="manager/bookSer" method="get">
        <input type="hidden" name="pageNo" value="${param.PageNo}"><%--应该是在其他地方赋值或才可以使用--%>

        <input type="hidden" name="action" value="${param.method}"><%--param 是获取地址栏中的参数--%>
        <input type="hidden" name="id" value="${requestScope.book.id}"><%--这里因为修改一个属性值需要获取到需要修改的那条id值 因为beanutils是以同类名注入值的--%>
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
 <td><input name="name" type="text" value="${requestScope.book.name}"/></td><%--通过进入Bookservlet这个页面获取到了这个value的回显值 没经过servlet页面的这样请求就不会有值
                          前面的name属性需要跟javabean中的类名一致 是因为beanUtils是通过类的相同名称注入值的--%>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@ include file="/pages/Jsp_file/footer.jsp" %>
</body>
</html>