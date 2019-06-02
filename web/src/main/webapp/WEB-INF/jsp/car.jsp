<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellpadding="5" cellspacing="1" >
        <tr>
            <th>brand</th>
            <th>model</th>
            <th>price</th>
            <th>status</th>
        </tr

        <c:forEach items="${carList}" var="post">
            <tr>
            <td>${post.brand}</td>
            <td>${post.model}</td>
            <td>${post.price}</td>
            <td>${post.status}</td>
                </c:forEach>
            </tr>
    </table>

        <form method="Post" action="car">

                Page size 1
                <select name="pageCount">
                    <option>5</option>
                    <option>10</option>
                    <option>15</option>
                </select>
                Page number
                <input type="textfield" name="pageNumber" />
                <input type="submit" value="submit" name="Submit"/>
        </form>

    </body>

</html>