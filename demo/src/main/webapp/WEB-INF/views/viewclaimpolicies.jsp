<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Policies List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Policy_Number</th><th>Customer Number</th><th>Claim_Id</th><th>Damage</th><th>date</th><th>status</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getPolicy_Number()}</td>
<td>${cust.getCustomer_Id()}</td>
<td>${cust.getClaim_Id()}</td>
<td>${cust.getDamage()}</td>
<td>${cust.getDate()}</td>
<td>${cust.getStatus()}</td>
<td><a href="/claimdetails/delete/${cust.getClaim_Id()}">Delete</a></td>
<td><a href="/claimdetails/update/${cust.getClaim_Id()}">Edit</a></td>
</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->