<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Company list</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>street</th><th>Contact</th><th>Pincode</th><th>country</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getCompany_Id()}</td>
<td>${cust.getName()}</td>
<td>${cust.getStreet()}</td>
<td>${cust.getContact_Information()}</td>
<td>${cust.getPincode()}</td>
<td>${cust.getCountry()}</td>
<td><a href="/admin/deletecompany/${cust.getCompany_Id()}">Delete</a></td>
<td><a href="/admin/editcompany/${cust.getCompany_Id()}">Edit</a></td>

</tr>
</c:forEach>
</table>
<br/>
<a href="/admin/companyform">Add New Company</a>