<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link href="createaccount.css" rel="stylesheet">
  </head>
  <body>
    <div class="testing">
      <img class="img-fluid" src="./assets/zyeda.png" alt="" />
    </div>
    <form method="post" action="Controller">
      <div class="login_form_container fa-medium">
        <div class="row">
          <div class="login_form">
            <h2>Create account</h2>
            <div class="input_group">
              <i class="fa fa-user"></i>
              <input type="text" placeholder="username" class="input_text" autocomplete="off" name="username" />
            </div>
            <div class="input_group">
              <i class="fa fa-unlock-alt"></i>
              <input type="password" placeholder="Password" class="input_text" autocomplete="off" name="password" />
            </div>
            
           <div class="input_group">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-person-vcard-fill"
                viewBox="0 0 16 16"
              >
                <path
                  d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm9 1.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4a.5.5 0 0 0-.5.5ZM9 8a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4A.5.5 0 0 0 9 8Zm1 2.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 0-1h-3a.5.5 0 0 0-.5.5Zm-1 2C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1 1 0 0 0 2 13h6.96c.026-.163.04-.33.04-.5ZM7 6a2 2 0 1 0-4 0 2 2 0 0 0 4 0Z"
                />
              </svg>
              <input
				  type="text"
				  placeholder="cin"
				  class="input_text"
				  autocomplete="off"
				  name="cin"
				  maxlength="8"
				  pattern="[0-9]{1,8}"
				  title="Please enter a numeric value up to 8 digits."
				/>

            </div>
            <div class="button_group" id="login_button">
              <input type="submit" name="action" value="register">
            </div>
            <div class="fotter">
              <p>have an account?</p>
              <a href="login.jsp" >Login</a>
            </div>
          </div>
        </div>
      </div>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </form>
  </body>
</html>
<div class="footer">
  <app-copyright></app-copyright>
</div>