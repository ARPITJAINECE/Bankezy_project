<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>User-list jsp</title>
</head>

<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>

        <c:forEach items="${sessionScope.user_details}" var="userDetails">
            <tr>

                <td>${userDetails.first_name}</td>
                <td>${userDetails.last_name}</td>
                <td>${userDetails.email}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="<c:url value='/employee'/>">Back to Employee Portal</a>
</body>
</html>