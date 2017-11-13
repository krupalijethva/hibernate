<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<form:form action="save.do" modelAttribute="reg" method="post">
<form:input path="fname" placeholder="first name"/></br>
<form:input path="lname" placeholder="last name"/></br>
<form:input path="uname" placeholder="user name"/></br>
<form:input path="pwd" placeholder="password"/>
<input type="submit"/>
</form:form>
</head>
<body>

</body>
</html>