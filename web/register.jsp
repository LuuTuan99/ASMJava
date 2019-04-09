<%@ page import="java.util.HashMap" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 4/8/2019
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String title = (String)request.getAttribute("title");
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    User user = (User)request.getAttribute("user");
    if (user == null){
        user = new User();
    }
%>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<form action="/register" method="post">

    FullName:<input type="text" name="fullname" value="<%=user.getFullname()%>">
    <%
        if (errors.containsKey("fullname")){
            ArrayList<String> fullNameError = errors.get("fullname");
            for (String error: fullNameError){%>
    <span class="mha-error"><%=error%></span>
    <%
        }
    }
    %>
    <br>
    UserName<input type="text" name="username" value="<%=user.getUsername()%>">
    <%
        if (errors.containsKey("username")){
             ArrayList<String> usernameError = errors.get("username");

            for (String error : usernameError){%>
                <span class="msq-errors"><%=error%></span>
    <%
            }
        }

    %>
    <br>
    Password<input type="password" name="password" value="<%=user.getPassword()%>">
    <%
        if (errors.containsKey("password")){
            ArrayList<String> passWordError = errors.get("password");
            for (String error : passWordError){%>
    <span class="hgi-errors"><%=error%></span>
    <%
        }
    }
    %>
    <br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>

