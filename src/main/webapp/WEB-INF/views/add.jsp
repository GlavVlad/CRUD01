<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1  align="center"><a href="/">CRUD</a></h1>
<script type="text/javascript">
    function f1() {
        var name = document.add.name.value;
        var age = document.add.age.value;
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
<form:form action="add" method="POST" modelAttribute="user" onsubmit="return f1()" name="add">
    <table align="center">
        <tr>
            <td><label for="name">Name: </label></td>
            <td><form:input path="name" id="name"/></td>
        </tr>
        <tr>
            <td><label for="age">Age: </label></td>
            <td><form:input path="age" id="age"/></td>
        </tr>
        <tr>
            <td><label for="isadmin">Admin? </label></td>
            <td><form:checkbox path="isadmin" id="isadmin"/></td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <input type="submit" value="Add" align="center"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
