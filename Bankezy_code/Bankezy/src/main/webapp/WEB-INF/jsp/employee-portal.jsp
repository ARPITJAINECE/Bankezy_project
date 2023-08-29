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
    <title>Dashboard</title>
</head>

<body>


      <c:import url="components/incl/header.jsp"/>




   <h1>Welcome to the Employee Portal</h1>
      <a href="<c:url value='/employee/user-list'/>">View User List</a>


     <c:import url="components/incl/footer.jsp"/>


