<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Policy</h1>
       <form:form method="post" action="/admin/policysave">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name_of_Policy"  maxlength="50" required="true"/></td>
         </tr>  
         <tr>
             <td>Cost per month: </td>
             <td><input name="cost_per_month" type="number" required="true"/></td>
         </tr>
        <tr>  
            <td>type :</td>  
            <td><form:select path="type" required="true">
                <form:option value="health">Health Policy</form:option>
                <form:option value="property">Property Policy</form:option>
                <form:option value="vehicle">Vehicle Policy</form:option>
            </form:select></td>
        </tr>
       
        <tr>  
            <td>Things to cover :</td>  
            <td><form:input path="Thingscover" maxlength="100" required="true" /></td>
        </tr>
       
        
        <tr>  
            <td>Company name :</td>  
            <td><form:select path="Company_Id">
                <c:forEach var="cust" items="${list}">
                <form:option value="${cust.getCompany_Id()}">${cust.getName()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        </tr>
        

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
