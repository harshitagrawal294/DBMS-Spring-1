<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Add New Claim Details</h1>

       <form:form method="post" action="/employee/claim/add" modelAttribute="claim">
      	    <table >
      	    <tr>
      	        <td> Customer </td>
      	        <td>
      	            <form:select path="Customer_Id" required="true" id="customer" onchange="getAssets()">
      	            <form:option value="0">--</form:option>
      	            <c:forEach var="customer" items="${customers}">
      	            <form:option value="${customer.getCustomer_Id()}">${customer.getName()}</form:option>
      	            </c:forEach>
      	            </form:select>
      	         </td>
      	    </tr>
      	    <tr>
      	        <td> Assets : </td>
      	        <td>
      	            <select id="assets" required="true" onchange="setPolicyNumber()">
      	            </select>
      	        </td>
      	    </tr>
      	    <form:hidden path="Policy_Number" id="policy_number" />
            <tr>
                <td> Damage : </td>
                <td><form:input path="damage" type="text" maxlength="100" required="true" /></td>
            </tr>
            <tr>
                <td> Status : </td>
                <td><form:select path="status" required="true">
                <form:option value="0">Pending</form:option>
                <form:option value="1">Confirm</form:option>     
                </form:select>
                </td>
            </tr>
            <tr>
                <td> Date : </td>
                <td><form:input path="date" type="date" required="true"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save" /></td>
            </tr>
            </table>
       </form:form>

       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
       <script>
           function addAssets(assets) {
               var i;
               var opts="<option value=\"-1\" > -- </option>";
               for(i=0; i<assets.length; i++){
                   opts += "<option value=" + assets[i].assetid +  ">" + assets[i].details + "</option>"
               }
               $("#assets").html(opts);
           }
           function getAssets() {
               $.ajax({
                   url:"/employee/api/get/assets",
                   type:"get",
                   dataType: "json",
                   data:{
                       Customer_Id: $('#customer').children("option:selected").val()
                   },
                   success: function(data, status, xhr){
                       console.log(data);
                       console.log(typeof data);
                       addAssets(data);
                   }
               })
           }
           function setPolicyNumber() {
               $.ajax({
                   url:"/employee/api/get_policy_number",
                   type:"get",
                   data:{
                       Customer_Id: $('#customer').children("option:selected").val(),
                       Asset_Id: $('#assets').children("option:selected").val(),
                   },
                   success: function(data, status, xhr){
                       console.log(data)
                       console.log(typeof data)
                       $('#policy_number').attr('value',data);
                   }
               })
           }
       </script>
