<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Document List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Link</th><th>Document type</th><th>Verification status</th><th>Customer Name</th><th>Delete</th><th>edit status</th></tr>
<c:forEach var="doc" items="${list}"> 
<tr>

<td>${doc.getLink_to_doc()}</td>
<td>${doc.getDocument_Type()}</td>
<td>${doc.getVerification_Status()}</td>
<td>${map.get(doc.getCustomer_Id())}</td>

<td><a href="/employee/deletedoc/${doc.getDocument_Id()}">Delete</a></td>
<td><a href="/employee/editstatus/${doc.getDocument_Id()}">Edit Status</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="/employee/adddoc">Add New Document</a>