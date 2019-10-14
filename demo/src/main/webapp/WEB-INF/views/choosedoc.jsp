<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		
       <form:form method="post" action="/employee/docsave">  
      	<table >  
          <td>Customers:</td>  

          <td><form:select path="Customer_Id">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getCustomer_Id()}">${cust.getName()}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
          <tr><td>Document type: </td>
            <td><form:input path="document_Type"  /></td>
         </tr>
         <tr><td>Link_to_doc: </td>
            <td><form:input path="Link_to_doc"  /></td>
         </tr>
         <tr><td>verification_Status: </td>
            <td><form:input path="verification_Status"  /></td>
         </tr>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
