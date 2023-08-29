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
    <title>User Details</title>
</head>
<body class="d-flex align-items-center justify-content-center">

       <h1>User Details</h1>
       <p><strong>Name:</strong> ${user.firstName} ${user.lastName}</p>
       <p><strong>Email:</strong> ${user.email}</p>
       <!-- <p><strong>Account Type:</strong> ${user.accountType}</p> -->
       <!-- Display other user details as needed -->
       <a href="<c:url value='/employee/user-list'/>">Back to User List</a>

 <h1>User Details</h1>
    <table>
        <tr>
            <th>Name:</th>
            <td>${user.firstName} ${user.lastName}</td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>Account Type:</th>
            <td>${user.accountType}</td>
        </tr>
    </table>
    <h2>Accounts</h2>
    <table>
        <tr>
            <th>Account Number</th>
            <th>Account Name</th>
            <th>Account Type</th>
        </tr>
        <c:forEach items="${user.accounts}" var="account">
            <tr>
                <td>${account.accountNumber}</td>
                <td>${account.accountName}</td>
                <td>${account.accountType}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value='/employee/user-list'/>">Back to User List</a>
</body>
</html>

