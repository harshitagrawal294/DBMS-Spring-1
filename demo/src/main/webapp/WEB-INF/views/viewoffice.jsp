<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Office list</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>street</th><th>Contact</th><th>Pincode</th><th>country</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getOffice_Id()}</td>
<td>${cust.getOffice_name()}</td>
<td>${cust.getStreet()}</td>
<td>${cust.getContact()}</td>
<td>${cust.getPincode()}</td>
<td>${cust.getCountry()}</td>
<td><a href="/admin/deleteoffice/${cust.getOffice_Id()}">Delete</a></td>
<td><a href="/admin/editoffice/${cust.getOffice_Id()}">Edit</a></td>

</tr>
</c:forEach>
</table>
<br/>
<a href="/admin/officeform">Add New Office</a>