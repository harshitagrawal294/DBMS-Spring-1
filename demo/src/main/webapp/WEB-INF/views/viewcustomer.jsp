<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Customer List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Username</th><th>Name</th><th>street</th><th>Pincode</th><th>country</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>

<td>${cust.getUsername()}</td>
<td>${cust.getName()}</td>
<td>${cust.getStreet()}</td>
<td>${cust.getPincode()}</td>
<td>${cust.getCountry()}</td>
<td><a href="/admin/deletecustomer/${cust.getCustomer_Id()}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->