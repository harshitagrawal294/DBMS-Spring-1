<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Policies List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Purchase</th><th>Expire</th><th>customer</th><th>policy</th><th>Employee</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getPolicy_Number()}</td>
<td>${cust.getDate_of_Purchase()}</td>
<td>${cust.getDateOfExpire()}</td>
<td>${cust.getCustomer_Id()}</td>
<td>${cust.getPolicy_Id()}</td>
<td>${cust.getUser_Id()}</td>
<td><a href="/customerpolicies/delete/${cust.getPolicy_Number()}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->