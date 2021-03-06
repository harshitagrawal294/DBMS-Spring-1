<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
        <title>Policy Bazaar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway:700|Roboto+Slab&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/css/main.css" type="text/css">
</head>
<body>
    <div class="container ft-rs">
<h1 class="ft-rw">Document List</h1>
<table>
<tr class="table-head"><th>Link</th><th>Document type</th><th>Verification status</th><th>Customer Name</th><th>Delete</th><th>edit status</th></tr>
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
<a class="detail-button-lg" href="/employee/adddoc">Add New Document</a>


</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>