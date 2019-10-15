<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Pending Transactions</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Nameof Customer</th><th>Money</th><th>Confirm</th></tr>
<c:forEach var="cust" items="${list}"> 
<tr>
<td>${map.get(cust.getTransactionid())}</td>
<td>${cust.getMoney()}</td>
<td><a href="/employee/changetstatus/${cust.getTransactionid()}">Confirm</a></td>
</tr>
</c:forEach>
</table>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->