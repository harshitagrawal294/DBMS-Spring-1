<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Employee list</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>street</th><th>Contact</th><th>Pincode</th><th>country</th><th>Delete</th></tr>

<c:forEach items="${rows}" var="map">
    <tr>
    <c:forEach items="${map}" var="entry">
        <td>${entry.value}<br></td>
        
    </c:forEach>
    <!-- <td>${map.get("Identification")}</td> -->
    <td><a href=/admin/deleteemployee/${map.get("User_Id")}>Delete</a></td>
    <td><a href=/employee/editemployee/${map.get("User_Id")}>Edit</a></td>
</tr>
</c:forEach>

</table>
<br/>