<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Claim Details</h1>
       <form:form method="post" action="/claimdetails/save">  
      	<table >  
         <tr>  
          <td>Damage : </td> 
          <td><form:input path="damage"  maxlength="100"/></td>
         </tr>  
        <tr>  
            <td>Status :</td>  
            <td><form:input path="status" maxlength="30"/></td>
        </tr>
        <tr>  
                <td>Date :</td>  
                <td><form:input path="date" type="date"/></td>
            </tr>
            
        <tr>  
                <td>Cusstomer Policy:</td>
            <td><form:select path="policy_Number">
                <c:forEach var="cust" items="${list1}">
                <form:option value="${cust.getPolicy_Number()}">${cust.getPolicy_Id()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        </tr>

        <tr>  
                <!-- <td>Damage : </td>  -->
                <td><form:hidden path="customer_Id"  maxlength="100"/></td>
               </tr> 
    
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
