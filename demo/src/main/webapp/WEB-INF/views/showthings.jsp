<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Things covered in this policy</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Things</th><th>Delete</th><th>Edit</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>

<td>${cust.getThings_Covered()}</td>
<td><a href="/policy/deletethings/${cust.getThings_Covered()}/${cust.getPolicy_Id()}">Delete</a></td>
<td><a href="/policy/editthings/${cust.getThings_Covered()}/${cust.getPolicy_Id()}">Edit</a></td>
</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->