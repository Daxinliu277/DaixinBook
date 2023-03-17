<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
    <jsp:include page="/pages/Jsp_file/header.jsp"/>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>
<jsp:include page="/pages/Jsp_file/menu.jsp"/>

<div id="main">

    <h1>你的订单已结算，订单号为${sessionScope.order}</h1>


</div>

<%@ include file="/pages/Jsp_file/footer.jsp" %>
</body>
</html>