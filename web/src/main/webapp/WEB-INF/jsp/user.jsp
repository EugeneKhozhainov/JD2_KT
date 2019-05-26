<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellpadding="5" cellspacing="1" >
        <tr>
            <th>name</th>
            <th>password</th>
            <th>role</th>
            <th>username</th>
        </tr>
        <tr>
            <td>${name}</td>
            <td>${password}</td>
            <td>${role}</td>
            <td>${username}</td>
        </tr>
</table>
</body>
</html>
