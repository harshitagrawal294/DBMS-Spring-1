<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Employee</h1>
       <form:form method="post" action="/admin/esave">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>
             <td>Date of joining: </td>
             <td><input name="date_of_joining" type="date" /></td>
         </tr>
         <tr>  
            <td>Street :</td>  
            <td><form:input path="street" maxlength="30"/></td>
        </tr>
        <tr>  
            <td>contact :</td>  
            <td><form:input path="contact_Information" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Gender :</td>  
            <td><form:input path="gender" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Pincode :</td>  
            <td><form:input path="pincode" maxlength="10"/></td>
        </tr>
        <tr>  
            <td>Country :</td>  
            <td><form:input path="country" maxlength="20"/></td>
        </tr>
        
        <tr>  
            <td>Employee type :</td>  
            <td><form:select path="identification">
                <c:forEach var="cust" items="${list1}">
                <form:option value="${cust.getIdentification()}">${cust.getType()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        </tr>
        <tr>  
            <td>Office_Id :</td>  
            <td><form:select path="Office_Id">
                <c:forEach var="cust" items="${list2}">
                <form:option value="${cust.getOffice_Id()}">${cust.getOffice_name()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        </tr>
        <tr>
            <td><form:hidden path="username"/></td>
        </tr>

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
