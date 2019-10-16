<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add Balance</h1>
       <form:form method="post" action="/customer/updatebalance">  
      	<table >  
         <tr>  
          <!-- <td>Customer_ID : </td>  -->
          <td><form:hidden path="Customer_Id"  /></td>
         </tr>  
        <tr>  
            <td>Money :</td>  
            <td><form:input path="balance" type="number" required="true"/></td>
        </tr>
        
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
