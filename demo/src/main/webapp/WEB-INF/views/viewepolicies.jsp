<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>${t} Policies </h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Cost</th><th>Things covered</th><th>Type</th><th>Company </th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${cust.getPolicy_id()}</td>
<td>${cust.getName_of_Policy()}</td>
<td>${cust.getCost_per_month()}</td>
<td>${cust.getThingscover() }</td>
<td>${cust.getType()}</td>
<td>${map.get(cust.getCompany_Id)}</td>
</tr>
</c:forEach>
</table>
<br>
<a href=/employee/policies/vehicle>Vehicle</a>
<a href=/employee/policies/property>Property</a>
<a href=/employee/policies/health>Health</a>
<!-- <a href="/policy/policyform">Add New Policy</a> -->