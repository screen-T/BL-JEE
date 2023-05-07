<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="icon" type="image/x-icon" href="./favicon.ico">
<link href="navbar.css" rel="stylesheet">
<link href="home.css" rel="stylesheet">
</head>
<body>
  <div class="d-none d-lg-block">
    <nav class="navbar sticky-top navbar-color">
      <img src="./assets/logo.png" alt="" class="logo_size_adjust" />
      <ul class="">
        <li class="">
          <a class="nav-element" href="Controller">Home </a>
        </li>  
        <li class=" ">
          <c:if test="${sessionScope.user != null}">
            <p class="nav-element">${sessionScope.user.username}</p>
          </c:if>
        </li>
        <li>
          <c:if test="${sessionScope.user == null}">
            <a class="nav-element" href="createaccount.jsp"> sign in / log in </a>
          </c:if>
        </li>
        <li class=" ">
         <c:if test="${sessionScope.user != null}">
            <a class="btn btn-color animate__animated animate__zoomIn" href="insertblog.jsp">addBlog</a>
          </c:if>
        </li>
        <li>
          <c:if test="${sessionScope.user != null}">
          <form method="post" action="Controller">
            <input class="btn nav-element" type="submit" name="action" value="logout">
            </form>
          </c:if>
        </li>
      </ul>
    </nav>
  </div>
</body>