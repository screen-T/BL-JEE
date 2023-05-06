<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="icon" type="image/x-icon" href="./favicon.ico">
<link href="navbar.css" rel="stylesheet">
<link href="home.css" rel="stylesheet">
</head>
<body>
<div class="d-none d-lg-block">
  <nav class="navbar sticky-top navbar-color">
    <a class="" href="/">
      <img src="logo.logo_path" alt=""  class="logo_size_adjust" />
    </a>
    <ul class="">
      <li class="">
        <a class="nav-element" href="/">Home </a>
      </li>
     
        <li class=" ">
          <a class="nav-element" href="/myblogs">My blogs</a>
        </li>
   
      <li class=" ">
        <a class="nav-element" href="/aboutus">About us </a>
      </li>

   

  
      <li class=" ">
       
        <input class="btn btn-color animate__animated animate__zoomIn" name="action" value="addBlog" type="submit">
          
       
   

        <a class="nav-element">logout</a>
      </li>


      <li>
        <a class="nav-element" href="/createaccount">
          sign in / log in
        </a>
      </li>
 </ul>
</nav>
</div>
</body>
