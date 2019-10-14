<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Company</h1>
       <form:form method="post" action="/admin/companysave">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  maxlength="50"/></td>
         </tr>  
        <tr>  
            <td>Street :</td>  
            <td><form:input path="street" maxlength="20"/></td>
        </tr>
        <tr>  
            <td>Contact :</td>  
            <td><form:input path="contact_Information" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Pincode :</td>  
            <td><form:input path="pincode" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Country :</td>  
            <td><form:input path="country" maxlength="25"/></td>
        </tr>

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
