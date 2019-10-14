<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Customer</h1>
       <form:form method="post" action="/customer/save">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
            <!-- <td>Us : </td>  -->
            <td><form:hidden path="username"  /></td>
           </tr>  
        <tr>  
            <td>Country :</td>  
            <td><form:input path="country" maxlength="20"/></td>
        </tr>
        <tr>  
            <td>Street :</td>  
            <td><form:input path="street" maxlength="50"/></td>
        </tr>
        <tr>  
            <td>Pincode :</td>  
            <td><form:input path="pincode" maxlength="20"/></td>
        </tr>

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
