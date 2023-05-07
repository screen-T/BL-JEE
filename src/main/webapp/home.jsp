<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<meta charset="ISO-8859-1">
<header>
<%@include file="navbar.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</header>
<div class="container">
  <div class="row">
<div class="container-1">
  <div class="line-it row">
    <c:forEach var="blog" items="${requestScope.Blogs}">
      <div class="px-4 mt-3">
      <div class="col-3 d-inline-block">
        <div class="card   " style="width: 18rem;">
          <img class="card-img-top" src="${blog.imagePath}" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">${blog.blogName}</h5>
             uploaded by: <h6 class="card-title">${blog.user.username}</h6>
            <p class="card-text">${blog.shortDescrption}</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
      </div>
    </c:forEach>
  </div>
</div>
  </div>
</div>
