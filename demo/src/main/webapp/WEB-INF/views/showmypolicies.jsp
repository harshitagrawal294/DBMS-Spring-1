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
<h1  class="ft-rw">Your Active Policy List</h1>
<table border="2" width="70%" cellpadding="2">
<tr  class="table-head"><th>Asset</th><th>Date of Expire</th><th>Date of Purchase</th><th>Policy name</th><th>Offered by</th><th>Status</th></tr>
<c:forEach var="doc" items="${list}"> 
<tr>

<td>${assetmap.get(doc.getPolicy_Number())}</td>
<td>${doc.getDateOfExpire()}</td>
<td>${doc.getDate_of_Purchase()}</td>
<td>${policymap.get(doc.getPolicy_Number())}</td>
<td>${companymap.get(doc.getPolicy_Number())}</td>
<td><a  href="/customer/linkdocs/${doc.getPolicy_Number()}">Link Documents </a></td>

</tr>
</c:forEach>
</table>
<br/>
<a class="detail-button" href=/customer>Home Page</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>