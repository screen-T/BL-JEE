<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Subjects List</title>
</head>
<body>

Liste des mati�res : <br/>

<ul>
<c:forEach var="sub" items="${requestScope.Blogs}">
<c:out value="<li>${sub.Blog} : ${sub.Blog.blog_name}
${sub.Blog.description}" escapeXml="false"></c:out>
<a href="Controller?action=deleteSubject&subId=${sub.subjectId}">
Sppprimer</a></li> <br/>
</c:forEach>
</ul>
</body>
</html>