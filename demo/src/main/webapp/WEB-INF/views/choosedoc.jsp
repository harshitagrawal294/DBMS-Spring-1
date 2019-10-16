<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		
       <form:form method="post" action="/employee/docsave">  
      	<table >  
          <td>Customers:</td>  

          <td><form:select path="Customer_Id" required="true">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getCustomer_Id()}">${cust.getName()}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
          <tr><td>Document type: </td>
            <td><form:input path="document_Type"  maxlength="100" required="true"/></td>
         </tr>
         <tr><td>Link_to_doc: </td>
            <td><form:input path="Link_to_doc" type="url" maxlength="200" required="true" /></td>
         </tr>
         <tr><td>verification_Status: </td>
            <td><form:select path="verification_Status" required="true">
               <form:option value="0">Pending</form:option>
               <form:option value="1">Confirm</form:option>
               </form:select>
            </td>
         </tr>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
