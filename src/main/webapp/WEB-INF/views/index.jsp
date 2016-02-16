<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<h1 align="center"><a href="/">CRUD</a></h1>
<form:form action="search" method="POST" modelAttribute="user" onsubmit="return f1()" name="search">
    <p align="center"><label for="name">Name: </label> <form:input id="name" path="name"/> <input type="submit"
                                                                                                  value="Search"/></p>
</form:form>
<table align="center">
    <tr>
        <td width="50" align="center">ID</td>
        <td width="250" align="center">Name</td>
        <td width="50" align="center">Age</td>
        <td width="50" align="center">Admin?</td>
        <td width="150" align="center">Date</td>
        <td width="100" align="center">Action</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td width="50" align="center">${user.id}</td>
            <td width="250" align="center">${user.name}</td>
            <td width="50" align="center">${user.age}</td>
            <td width="50" align="center">${user.isadmin}</td>
            <td width="150" align="center">${user.date}</td>
            <td width="100" align="center"><a href="edit?id=${user.id}">edit</a> / <a
                    href="delete?id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<table align="center">
    <tr>
        <c:forEach begin="1" end="${pages}" step="1" var="i">
            <td><a href="pages?page=${i}">${i}</a></td>
        </c:forEach>
    </tr>
</table>
<br><br>
<p align="center"><a href="add">add</a></p>

<script type="text/javascript">
    function f1() {
        var name = document.search.name.value;
        if (/^[A-z А-я]+$/.test(name)) {
            return true;
        } else {
            window.alert("Wrong name")
            return false;
        }
    }
</script>
</body>
</html>