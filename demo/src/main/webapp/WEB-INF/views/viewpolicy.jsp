<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Policy list</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Cost</th><th>Type</th><th>Company id</th><th>Delete</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getPolicy_id()}</td>
<td>${cust.getName_of_Policy()}</td>
<td>${cust.getCost_per_month()}</td>
<td>${cust.getType()}</td>
<td>${cust.getCompany_Id()}</td>
<td><a href="/policy/delete/${cust.getPolicy_id()}">Delete</a></td>
<td><a href="/policy/edit/${cust.getPolicy_id()}">Edit</a></td>
<td><a href="/policy/addthingscovered/${cust.getPolicy_id()}">Add things covered</a></td>


</tr>
</c:forEach>
</table>
<br/>
<a href="/policy/policyform">Add New Policy</a>