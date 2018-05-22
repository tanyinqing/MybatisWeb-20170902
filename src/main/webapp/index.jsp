<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/9 0009
  Time: 下午 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/user/signIn" method="post">
  <%--<form action="/user/" method="post">--%>
    <%--<input type="hidden" name="action" value="signIn">--%>
    <input name="username" placeholder="Username" value="tan"><br>
    <input type="password" name="password" placeholder="Password" value="123"><br>
    <input type="submit" value="Sign in">
  </form><%--<form action="/user" method="post">
    <input type="hidden" name="action" value="signIn">
    <input name="username" placeholder="Username" value="tan"><br>
    <input type="password" name="password" placeholder="Password" value="123"><br>
    <input type="submit" value="Sign in">
  </form>--%>
  ${requestScope.message}
  <p>
    <a href="sign_up.jsp">Sign up</a>
  </p>
  <hr>
  <p><a href="/user/queryAll">List all users</a></p>
  </body>
</html>
