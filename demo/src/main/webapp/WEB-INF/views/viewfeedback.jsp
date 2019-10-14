<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Feedback List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Employee_Id</th><th>Feedback</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getSerial_Number()}</td>
<td>${cust.getUser_Id()}</td>
<td>${cust.getRemarks()}</td>
<td><a href="/feedback/delete/${cust.getSerial_Number()}">Delete</a></td>
<td><a href="/feedback/edit/${cust.getSerial_Number()}">Edit</a></td>
<td><a href="/feedback/viewbyid/${cust.getUser_Id()}">View all feedback for this person</a></td>
</c:forEach>
</table>
<br/>
<a href="/feedback/feedbackform">Add New feedback</a>