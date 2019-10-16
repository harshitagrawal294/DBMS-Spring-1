<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Update the Salary</h1>
       <form:form method="post" action="/admin/update_salary">  
      	<table >  
        <tr>
            <td><form:hidden path="identification"/></td>
        </tr> 
        <tr>
            <td>New Salary :</td>  
            <td><form:input path="salary" Type="number" required="true" /></td>
        </tr>
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
