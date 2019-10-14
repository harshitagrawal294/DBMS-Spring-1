<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Customer Policys</h1>
       <form:form method="post" action="/customerpolicies/save">  
      	<table >  
         <tr>  
          <td>Date of Purchase : </td> 
          <td><form:input path="date_of_Purchase"  type="Date"/></td>
         </tr>  
        <tr>  
            <td>Date of Expire :</td>  
            <td><form:input path="dateOfExpire" type="Date"/></td>
        </tr>
        <tr>  
                <td>Policy:</td>
            <td><form:select path="Policy_Id">
                <c:forEach var="cust" items="${list1}">
                <form:option value="${cust.getPolicy_id()}">${cust.getName_of_Policy()}</form:option>
                </c:forEach>
            </form:select>
        </td>
        </tr>
    </tr>
    <tr>  
            <td>Customer :</td>
        <td><form:select path="customer_Id">
            <c:forEach var="cust" items="${list3}">
            <form:option value="${cust.getCustomer_Id()}">${cust.getName()}</form:option>
            </c:forEach>
        </form:select>
    </td>
    </tr>
    <tr>  
            <td>Employee  :</td>
        <td><form:select path="User_Id">
            <c:forEach var="cust" items="${list2}">
            <form:option value="${cust.getUser_Id()}">${cust.getName()}</form:option>
            </c:forEach>
        </form:select>
    </td>
    </tr>
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
