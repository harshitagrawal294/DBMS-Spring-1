<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Claim Details</h1>
       <form:form method="post" action="/claimdetails/upd">  
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
                <!-- <td>Cusstomer Policy:</td> -->
            <td><form:hidden path="policy_Number" /></td>
        </td>
        </tr>
        <tr>  
                <!-- <td>Cusstomer Policy:</td> -->
            <td><form:hidden path="claim_Id" /></td>
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
