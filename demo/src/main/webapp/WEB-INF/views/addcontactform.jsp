<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Contact</h1>
       <form:form method="post" action="/customer/savecontact">  
      	<table >  
         <tr>  
          <!-- <td>Customer_ID : </td>  -->
          <td><form:hidden path="customer_Id"  /></td>
         </tr>  
        <tr>  
            <td>Contact :</td>  
            <td><form:input path="contact" maxlength="20"/></td>
        </tr>
        
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
