<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

            <c:if test = "${p1 > 0}">
            <p>Low Balance,Choose some other policy ${p1}</p>
            </c:if>
       <form:form method="post" action="/customer/asset/policy/buy">  
      	<table >  
                <td><form:hidden path="Asset_Id"  /></td>
          <td>Policy:</td>  

          <td><form:select path="Policy_Id" required="true">
          		<c:forEach var="cust" items="${policies}">
          		<form:option value="${cust.getPolicy_id()}">${cust.getName_of_Policy()}</form:option>
          		</c:forEach>
          	</form:select>
          </td>
          
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
