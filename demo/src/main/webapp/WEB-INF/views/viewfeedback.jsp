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
<h1>Feedback List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Employee_Id</th><th>Feedback</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getSerial_Number()}</td>
<td>${cust.getUser_Id()}</td>
<td>${cust.getRemarks()}</td>
<td><a href="/feedback/delete/${cust.getSerial_Number()}">Delete</a></td>
<td><a href="/feedback/edit/${cust.getSerial_Number()}">Edit</a></td>
<td><a href="/feedback/viewbyid/${cust.getUser_Id()}">View all feedback for this person</a></td>
</c:forEach>
</table>
<br/>
<a href="/feedback/feedbackform">Add New feedback</a>


</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>