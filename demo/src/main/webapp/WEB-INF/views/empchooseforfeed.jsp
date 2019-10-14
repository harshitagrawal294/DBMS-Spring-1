<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		
       <form:form method="post" action="/feedback/addfeedback">  
      	<table >  
          <td>Employee:</td>  
          <td><form:select path="User_Id">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getUser_Id()}">${cust.getName()}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
         </tr> 
         <tr>  
          
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
