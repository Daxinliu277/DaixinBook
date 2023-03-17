<%--
  Created by IntelliJ IDEA.
  User: 80629
  Date: 2022/8/17
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <%@ include file="header.jsp"%>
  <body>
  <div id="page_nav">
    <c:if test="${requestScope.pages.pageNo>1}">
      <a href="${requestScope.pages.url}&PageNo=1">回到第一页</a>
      <a href="${requestScope.pages.url}&PageNo=${requestScope.pages.pageNo-1}">上一页</a>
    </c:if>
    <%--        <a href="#">3</a>--%>
    <%--        【${requestScope.pages.pageNo}】--%>
    <%--        <a href="#">5</a>--%>

    <c:choose>
      <c:when test="${requestScope.pages.pageTotal<=5}">

        <c:forEach begin="1" end="${requestScope.pages.pageTotal}" var="i">
          <c:if test="${i==requestScope.pages.pageNo}">
            【<a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>】
          </c:if>
          <c:if test="${i!=requestScope.pages.pageNo}">
            <a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>
          </c:if>
        </c:forEach>
      </c:when>

      <c:when test="${requestScope.pages.pageTotal>5}">

        <c:choose>
          <c:when test="${requestScope.pages.pageTotal<3}">
            <c:forEach begin="1" end="5" var="i">
              <c:if test="${i==requestScope.pages.pageNo}">
                【<a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>】
              </c:if>
              <c:if test="${i!=requestScope.pages.pageNo}">
                <a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>
              </c:if>
            </c:forEach>
          </c:when>
          <c:when test="${requestScope.pages.pageNo>requestScope.pages.pageTotal-3}">
            <c:forEach begin="${requestScope.pages.pageTotal-4}" end="${requestScope.pages.pageTotal}"
                       var="i">
              <c:if test="${i==requestScope.pages.pageNo}">
                【<a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>】
              </c:if>
              <c:if test="${i!=requestScope.pages.pageNo}">
                <a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>
              </c:if>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <c:forEach begin="${requestScope.pages.pageNo-1}" end="${requestScope.pages.pageNo+2}" var="i">

              <c:if test="${i==requestScope.pages.pageNo}">
                【<a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>】
              </c:if>
              <c:if test="${i!=requestScope.pages.pageNo}">
                <a href="${requestScope.pages.url}&PageNo=${i}"> ${i}</a>
              </c:if>
            </c:forEach>
          </c:otherwise>

        </c:choose>
      </c:when>
    </c:choose>


    <c:if test="${requestScope.pages.pageNo<requestScope.pages.pageTotal}">
      <a href="${requestScope.pages.url}&PageNo=${requestScope.pages.pageNo+1}">下一页</a>
      <a href="${requestScope.pages.url}&PageNo=${requestScope.pages.pageTotal}">最后一页</a>
    </c:if>
    共${requestScope.pages.pageTotal}页，${requestScope.pages.pageCount}条记录 到第<input name="pn"
                                                                                         value="${requestScope.pages.pageNo}"
                                                                                         id="pn_input"/>页
    <input id="searchbtn" type="button" value="确定">
    <script>
      $(function () {
        $("#searchbtn").click(function () {
          var val = $("#pn_input").val();
          if (val > 0 && val <=${requestScope.pages.pageTotal}) {
            location.href = "${requestScope.basePath}${requestScope.pages.url}&PageNo=" + val;
          } else {
            alert("没有该需要的页面：" + val);
          }
        })
      });
    </script>
  </div>
  </body>
</html>
