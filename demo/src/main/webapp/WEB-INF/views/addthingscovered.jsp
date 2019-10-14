<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add Things covered</h1>
       <form:form method="post" action="/policy/addthings">  
      	<table >  
         <tr>  
          <!-- <td>Customer_ID : </td>  -->
          <td><form:hidden path="Policy_Id"  /></td>
         </tr>  
        <tr>  
            <td>Thing it covers :</td>  
            <td><form:input path="Things_Covered" /></td>
        </tr>
        
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
