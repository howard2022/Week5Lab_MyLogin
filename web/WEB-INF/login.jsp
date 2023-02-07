<%-- 
    Document   : login
    Created on : 7-Feb-2023, 10:14:18 AM
    Author     : howar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Username: <input type="text" name="usernameInput" value="${username}"><br>
            Password: <input type="password" name="passwordInput" value="${password}"><br>
            <input type="submit" value="Log in">
        </form> 
    </body>
</html>
