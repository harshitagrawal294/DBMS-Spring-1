<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<h1>Add Asset</h1>
       <form:form method="post" action="/customer/asset/add">
      	<table >
      	<form:hidden path="customerid" />
        <tr>
            <td>Details:</td>
            <td><form:input path="details" type="text" maxlength="200" required="true"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><form:select path="type" required="true">
                <option value="vehicle">Vehicle</option>
                <option value="property">Property</option>
                <option value="health">Health</option></form:select>
            </td>
        </tr>
         <tr>
          <td><input type="submit" value="Save" /></td>
         </tr>
        </table>
       </form:form>
