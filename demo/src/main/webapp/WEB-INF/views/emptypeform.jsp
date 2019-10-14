<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Employee</h1>
       <form:form method="post" action="/admin/emptypesave">  
      	<table >  
         <tr>  
          <td>Type : </td> 
          <td><form:input path="type"  maxlength="30"/></td>
         </tr>  
        <tr>  
            <td>Salary :</td>  
            <td><form:input path="salary" /></td>
        </tr>
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
