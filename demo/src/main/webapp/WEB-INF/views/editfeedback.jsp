<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Feedback</h1>
       <form:form method="post" action="/employee/editfeedbacks">  
      	<table >  
         <tr>  
          <td>Remarks : </td> 
          <td><form:input path="Remarks"  /></td>
         </tr>  
         <tr><form:hidden path="Serial_Number"/></tr>
         <tr><form:hidden path="User_Id"/></tr>
         <!-- <tr><td>Employee:</td>   -->
          <!-- <td><form:select path="User_Id">
          		<c:forEach var="cust" items="${list}">
          		<form:option value="${cust.getUser_Id()}">${cust.getName()}</form:option>
          		</c:forEach>
          	</form:select>
          </td> -->
        </tr>
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
