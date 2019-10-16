<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Employee Type list</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Type</th><th>Salary</th><th>Delete</th><th>Update Salary</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getType()}</td>
<td>${cust.getSalary()}</td>
<td><a href="/admin/deleteemptype/${cust.getIdentification()}">Delete</a></td>
<td><a href="/admin/updateemptype/${cust.getIdentification()}">Update Salary</a></td>

</tr>
</c:forEach>
</table>
<br/>
<a href="/admin/emptypeform">Add New employee_type</a>