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
<h1>Feedback</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Remarks</th><th>Wriitenby</th><th>Delete</th><th>Edit</th></tr>
<c:forEach var="doc" items="${list}"> 
<tr>

<td>${doc.getRemarks()}</td>
<td>${map.get(doc.getUser_Id())}</td>
<c:if test="${doc.getUser_Id()==e.getUser_Id()}">
<td><a href="/employee/deletefeedback/${doc.getSerial_Number()}">Delete</a></td>
<td><a href="/employee/editfeedback/${doc.getSerial_Number()}">Edit Status</a></td>
</c:if>
</tr>
</c:forEach>
</table>
<br/>
<a href="/employee/addfeedback">Add New Feedback</a>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>