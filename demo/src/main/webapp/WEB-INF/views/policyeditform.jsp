<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Policy </h1>
       <form:form method="post" action="/admin/updatepolicy">  
      	<table >
                <tr>  
                <!-- <td>Office_Id : </td>  -->
                <td><form:hidden path="policy_id" /></td>
                <td><form:hidden path="Company_Id" /></td>
                </tr>      
                <tr>  
                <td>Name : </td> 
                <td><form:input path="name_of_Policy"  maxlength="50"/></td>
                </tr>  
                <tr>
                    <td>Cost per month: </td>
                    <td><input name="cost_per_month" /></td>
                </tr>
                <tr>  
                    <!-- <td>type :</td>   -->
                    <td><form:hidden path="type" /></td>
                </tr>
                <tr>  
                        <td>Things to cover :</td>  
                        <td><form:input path="Thingscover" maxlength="100"/></td>
                    </tr>
                
                
                
        
                <tr>  
                <td><input type="submit" value="Save" /></td>  
                </tr>  
        </table>  
       </form:form>  
