<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>home</title>
</head>
<body>

<c:choose>
  <c:when test="${empty requestScope.Blogs}">
    <p>No blogs found.</p>
  </c:when>
  <c:otherwise>
    <ul>
    <c:forEach var="blog" items="${requestScope.Blogs}">
      <li>${blog.blogName}: ${blog.description}</li>
    </c:forEach>
    </ul>
  </c:otherwise>
</c:choose>

</body>
</html>
