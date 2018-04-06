<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="ma.ehtp.hibernate.Person" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Java EE</title>
</head>
<body>
    <h1>Hello JSP and Servlet!</h1>
    <%! String myName = "El Arbi"; %>
    <% myName += " On 2018"; %>
    <h1>Code by <%= myName%></h1>

    <jsp:useBean id = "houseRepo" class = "ma.ehtp.hibernate.HouseRepository" />
    <%
      Person elArbi = new Person("Mohammed");
      houseRepo.addPerson(elArbi);
    %>

   <h2>Insertion en BD de </h2><p><%= elArbi.getFirstName() %></p>

  <p> <%= request.getRequestURI().toString() %> </p>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>

   <%-- Comment --%>

   <form action = "index.jsp" method = "POST">
           First Name: <input type = "text" name = "first_name">
           <br />
           Last Name: <input type = "text" name = "last_name" />
   <input type = "submit" value = "Submit" />
   </form>

 <h2>Paramètre envoyer au serveur : </h2><p></p>
     <%= request.getParameter("first_name") %>
     <%= request.getParameter("last_name") %>
</body>

</html>