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

<h1>Employee list</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Name</th><th>Employee ID</th><th>Date of Joining</th><th>Street</th><th>Contact</th><th>Gender</th><th>Pincode</th><th>country</th><th>EMployeee type id</th><th>Office id</th><th>Employee type</th><th>Office name</th><th>Delete</th></tr>

<c:forEach items="${rows}" var="map">
    <tr>
    <c:forEach items="${map}" var="entry">
        <td>${entry.value}<br></td>
        
    </c:forEach>
    <!-- <td>${map.get("Identification")}</td> -->
    <td><a href=/admin/deleteemployee/${map.get("User_Id")}>Delete</a></td>
    <td><a href=/admin/editemployee/${map.get("User_Id")}>Edit</a></td>
</tr>
</c:forEach>

</table>
<br/>
<a href="/admin/addemployee">Add new employee</a>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>