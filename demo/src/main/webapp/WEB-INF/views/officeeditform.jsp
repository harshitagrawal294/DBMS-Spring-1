<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Office details</h1>
       <form:form method="post" action="/admin/updateoffice">  
      	<table >
                <tr>  
                        <!-- <td>Office_Id : </td>  -->
                        <td><form:hidden path="office_Id" /></td>
                       </tr>      
         <tr>  
          <td>Name : </td> 
          <td><form:input path="office_name"  maxlength="50"/></td>
         </tr>  
        <tr>  
            <td>Street :</td>  
            <td><form:input path="street" maxlength="30"/></td>
        </tr>
        <tr>  
            <td>Contact :</td>  
            <td><form:input path="contact" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Pincode :</td>  
            <td><form:input path="pincode" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Country :</td>  
            <td><form:input path="country" maxlength="15"/></td>
        </tr>

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
