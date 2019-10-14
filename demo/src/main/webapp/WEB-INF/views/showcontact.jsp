<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Contact List for the customer</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Contact</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>

<td>${cust.contact}</td>
<td><a href="/customer/deletecontact/${cust.contact}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="/customer/addcontact">Add New Contact</a>