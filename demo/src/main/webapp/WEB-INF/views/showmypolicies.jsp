<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Your Active Policy List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Asset</th><th>Date of Expire</th><th>Date of Purchase</th><th>Policy name</th><th>Offered by</th><th>Status</th></tr>
<c:forEach var="doc" items="${list}"> 
<tr>

<td>${assetmap.get(doc.getPolicy_Number())}</td>
<td>${doc.getDateOfExpire()}</td>
<td>${doc.getDate_of_Purchase()}</td>
<td>${policymap.get(doc.getPolicy_Number())}</td>
<td>${companymap.get(doc.getPolicy_Number())}</td>
<td><a href="/customer/linkdocs/${doc.getPolicy_Number()}">Link Documents </a></td>

</tr>
</c:forEach>
</table>
<br/>