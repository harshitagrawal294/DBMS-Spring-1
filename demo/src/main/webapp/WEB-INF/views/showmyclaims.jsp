<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Your Claim List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Asset</th><th>Damage</th><th>Date</th><th>Policy name</th><th>Offered by</th><th>Status</th></tr>
<c:forEach var="doc" items="${list}"> 
<tr>

<td>${assetmap.get(doc.getClaim_Id())}</td>
<td>${doc.getDamage}</td>
<td>${doc.getDate()}</td>
<td>${policymap.get(doc.getClaim_Id())}</td>
<td>${companymap.get(doc.getClaim_Id())}</td>
<c:if test="${doc.getStatus==0}">
<td>Pending</td>
</c:if>
<c:if test="${doc.getStatus==1}">
<td>Approved</td>
</c:if>

</tr>
</c:forEach>
</table>
<br/>