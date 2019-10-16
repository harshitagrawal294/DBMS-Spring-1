<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Feedback</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Remarks</th><th>Wriitenby</th></tr>
<c:forEach var="doc" items="${list}"> 
<tr>

<td>${doc.getRemarks()}</td>
<td>${map.get(doc.getUser_Id())}</td>

<td><a href="/admin/deletefeedback/${doc.getSerial_Number()}">Delete</a></td>
<!-- <td><a href="/admin/editfeedback/${doc.getSerial_Number()}">Edit Status</a></td> -->

</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/employee/addfeedback">Add New Feedback</a> -->