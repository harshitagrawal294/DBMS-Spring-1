<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Employee </h1>
       <form:form method="post" action="/admin/editform">  
      	<table >  
              <tr>
                  <td><form:hidden path="user_Id"   /></td>
              </tr>
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name" maxlength="50" required="true"/></td>
         </tr>  
         <tr>
             <td>Date of joining: </td>
             <td><input name="date_of_joining" type="date" required="true"/></td>
         </tr>
         <tr>  
            <td>Street :</td>  
            <td><form:input path="street" maxlength="30" required="true"/></td>
        </tr>
        <tr>  
            <td>contact :</td>  
            <td><form:input path="contact_Information" type="number" pattern="[0-9]{10}" required="true"/></td>
        </tr>
        <tr>  
            <td>Gender :</td>  
            <td><form:select path="gender" required="true">
            <form:option value="male">Male</form:option>
            <form:option value="female">female</form:option>    
            </form:select>
            </td>
        </tr>
        <tr>  
            <td>Pincode :</td>  
            <td><form:input path="pincode" type="number" required="true"/></td>
        </tr>
        <tr>  
            <td>Country :</td>  
            <td><form:input path="country" maxlength="20" required="true"/></td>
        </tr>
        
        <tr>  
            <td>Employee type :</td>  
            <td><form:select path="identification" required="true">
                <c:forEach var="cust" items="${list1}">
                <form:option value="${cust.getIdentification()}">${cust.getType()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        </tr>
        <tr>  
            <td>Office_Id :</td>  
            <td><form:select path="Office_Id" required="true">
                <c:forEach var="cust" items="${list2}">
                <form:option value="${cust.getOffice_Id()}">${cust.getOffice_name()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        <td><form:hidden path="username"/></td>
        </tr>

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
