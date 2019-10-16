<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Customer List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>street</th><th>Pincode</th><th>country</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.customer_Id}</td>
<td>${cust.name}</td>
<td>${cust.street}</td>
<td>${cust.pincode}</td>
<td>${cust.country}</td>
<td><a href="/admin/deletecustomer/${cust.customer_Id}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->