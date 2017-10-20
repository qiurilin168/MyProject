<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qiu
  Date: 2017/10/18
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path  = request.getContextPath();
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form method="post" action="<%=path%>/user/login">
      <input name="name"/>
      <input type="password" name="password"/>
      <input type="submit" value="登录"/>
    </form>
  <shiro:authenticated>
    认证<br/>
  </shiro:authenticated>
  <shiro:hasRole name="customer">
    customer<br/>
  </shiro:hasRole>
  <shiro:hasRole name="user">
    user<br/>
  </shiro:hasRole>
  <shiro:hasPermission name="user:add">
    user:add<br/>
  </shiro:hasPermission>
  <shiro:hasPermission name="customer:update">
    customer:update<br/>
  </shiro:hasPermission>
  </body>
</html>
