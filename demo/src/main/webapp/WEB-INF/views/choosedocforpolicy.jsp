<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		
       <form:form method="post" action="/customer/linkdocsave">  
      	<table >  
          <td>Documents: </td>  
          <td><form:select path="documentid">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getDocument_Id()}">${cust.getDocument_Type()}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
         <td><form:hidden path="customerid" /></td>
         <td><form:hidden path="policynumber" /></td>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
