<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add Doc</h1>
       <form:form method="post" action="/document/save">  
      	<table >  
         <tr>  
          <!-- <td>Name : </td>  -->
          <td><form:hidden path="Customer_Id"  /></td>
         </tr>  
        <tr>  
            <td>document type:</td>  
            <td><form:input path="document_Type" maxlength="100"/></td>
        </tr>
        <tr>  
            <td>Link to doc :</td>  
            <td><form:input path="Link_to_doc" maxlength="200"/></td>
        </tr>
        

         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
