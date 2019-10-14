<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Feedback</h1>
       <form:form method="post" action="/employee/savefeedback">  
      	<table >  
         <tr>  
          <td>Remarks : </td> 
          <td><form:input path="Remarks"  /></td>
         </tr>  
         <tr><form:hidden path="User_Id"/></tr>

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
