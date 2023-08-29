<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap-5.0.2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="../css/fontawesome-free-6.4.2-web/css/all.css">
        <link rel="stylesheet" href="../css/main.css">
        <script src="../js/bootstrap.bundle.js"></script>
    <title>delete confirmation</title>
</head>

<body>
     <h1>Delete Confirmation</h1>
        <p>Are you sure you want to delete this user?</p>
        <form action="<c:url value='/employee/delete-user/${user.userId}'/>" method="post">
            <input type="submit" value="Delete">
            <a href="<c:url value='/employee/user-list'/>">Cancel</a>
        </form>

</body>
</html>