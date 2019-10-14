<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Choose Customer</h1>
       <form:form method="post" action="/claimdetails/newclaimform">  
      	<table >  
         
        
    <tr>  
            <td>Customer :</td>
        <td><form:select path="customer_Id">
            <c:forEach var="cust" items="${list}">
            <form:option value="${cust.getCustomer_Id()}">${cust.getName()}</form:option>
            </c:forEach>
        </form:select>
    </td>
    </tr>
   
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
