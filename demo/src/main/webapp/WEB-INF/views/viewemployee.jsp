<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

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