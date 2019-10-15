<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Your Active Policy List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Secured Asset id</th><th>details</th><th>Type</th><th>Policy name</th><th>Offered by</th><th>Status</th></tr>
<c:forEach var="row" items="${secured_assets}">
<tr>

<td>${row.getAssetid()}</td>
<td>${row.getDetails()}</td>
<td>${row.getType()}</td>
<td><a href="/customer/asset/${row.getAssetid()}/policy/discontinue">Dicontinue the policy</a></td>
</tr>
</c:forEach>
</table>

<table border="2" width="70%" cellpadding="2">
<tr><th>Unsecured Asset</th><th>Date of Expire</th><th>Date of Purchase</th><th>Policy name</th><th>Offered by</th><th>Status</th></tr>
<c:forEach var="row" items="${unsecured_assets}">
<tr>

<td>${row.getAssetid()}</td>
<td>${row.getDetails()}</td>
<td>${row.getType()}</td>
<td><a href="/customer/asset/${row.getAssetid()}/policy/buy">Buy Policy for this asset</a></td>
</tr>
</c:forEach>
</table>
<br/>