<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		
       <form:form method="post" action="/document/adddocs">  
      	<table >  
          <td>Customers:</td>  
          <td><form:select path="customer_Id">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getCustomer_Id()}">${cust.getName()}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
