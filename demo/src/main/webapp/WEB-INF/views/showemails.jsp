<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Email List for the customer</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Email</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>

<td>${cust.getEmail_Id()}</td>
<td><a href="/customer/deleteemails/${cust.getEmail_Id()}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="/customer/addemails">Add New Email</a>