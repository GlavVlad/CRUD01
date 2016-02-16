<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1  align="center"><a href="/">CRUD</a></h1>
<script type="text/javascript">
    function f1() {
        var name = document.edit.name.value;
        var age = document.edit.age.value;
        if (/^[A-z А-я]+$/.test(name) && name.length < 26) {
            if (age > 0 && age < 128) {
                return true;
            } else {
                window.alert("Wrong age (1-127)");
                return false;
            }
        } else {
            window.alert("Wrong name")
            return false;
        }
    }
</script>
<form:form action="edit?id=${user.id}" method="POST" modelAttribute="user" onsubmit="return f1()" name="edit">
    <form:input type="hidden" path="id" id="id"/>
    <table align="center">
        <tr>
            <td>ID:</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td><label for="name">Name: </label></td>
            <td><form:input path="name" id="name"/></td>
        </tr>
        <tr>
            <td><label for="age">Age: </label></td>
            <td><form:input path="age" id="age" maxlength="3"/></td>
        </tr>
        <tr>
            <td><label for="isadmin">Admin? </label></td>
            <td><form:checkbox path="isadmin" id="isadmin"/></td>
        </tr>
        <tr>
            <td>Created Date:</td>
            <td>${user.date}</td>
        </tr>
        <tr align="center">
            <td colspan="5">
                <input type="submit" value="Update"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
