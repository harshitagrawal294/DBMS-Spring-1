<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Email</h1>
       <form:form method="post" action="/customer/saveemails">  
      	<table >  
         <tr>  
          <!-- <td>Customer_ID : </td>  -->
          <td><form:hidden path="Customer_Id"  /></td>
         </tr>  
        <tr>  
            <td>Email :</td>  
            <td><form:input path="Email_Id" type="email" maxlength="40" required="true"/></td>
        </tr>
        
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
