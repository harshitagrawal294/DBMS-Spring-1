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
		<h1>Edit Policy </h1>
       <form:form method="post" action="/admin/updatepolicy">  
      	<table >
                <tr>  
                <!-- <td>Office_Id : </td>  -->
                <td><form:hidden path="policy_id" /></td>
                <td><form:hidden path="Company_Id" /></td>
                </tr>      
                <tr>  
                <td>Name : </td> 
                <td><form:input path="name_of_Policy"  maxlength="50" required="true"/></td>
                </tr>  
                <tr>
                    <td>Cost per month: </td>
                    <td><input name="cost_per_month" type="number" required="true" /></td>
                </tr>
                <tr>  
                    <!-- <td>type :</td>   -->
                    <td><form:hidden path="type" /></td>
                </tr>
                <tr>  
                        <td>Things to cover :</td>  
                        <td><form:input path="Thingscover" maxlength="100" required="true"/></td>
                    </tr>
                
                
                
        
                <tr>  
                <td><input type="submit" value="Save" /></td>  
                </tr>  
        </table>  
       </form:form>  

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>