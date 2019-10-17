<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
        <title>Policy Bazaar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway:700|Roboto+Slab&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/css/main.css" type="text/css">
</head>
<body>
    <div class="container ft-rs">
		<h1>Add New Feedback</h1>
       <form:form method="post" action="/employee/editfeedbacks">  
      	<table >  
         <tr>  
          <td>Remarks : </td> 
          <td><form:input path="Remarks"  maxlength="200" required="true"/></td>
         </tr>  
         <tr><form:hidden path="Serial_Number"/></tr>
         <tr><form:hidden path="User_Id"/></tr>
         <!-- <tr><td>Employee:</td>   -->
          <!-- <td><form:select path="User_Id">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getUser_Id()}">${cust.getName()}</form:option>
          		</c:forEach>
          	</form:select>
          </td> -->
        </tr>
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  

      </div>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  
  </body>
  </html>