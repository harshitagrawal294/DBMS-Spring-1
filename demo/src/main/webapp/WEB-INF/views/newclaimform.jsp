<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
        <title>Policy Bazaar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway:700|Roboto+Slab&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/css/main.css" type="text/css">
</head>
<body>
    <div class="container ft-rs">
		<h1>Add New Claim Details</h1>
       <select>
        <option></option
       </select


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

       <script>
           function addMfName(mf_names) {
               var i;
               var opts="<option value=\"-1\" > -- </option>";
               console.log(mf_names.length)
               for(i=0; i<mf_names.length; i++){
                   opts += "<option value=" + mf_names[i] +  ">" + mf_names[i] + "</option>"
               }
               $("#mf_name").html(opts);
           }
           function getMfName() {
               $.ajax({
                   url:"/api/get/mf_names",
                   type:"get",
                   data:{
                       is_generic: $('#is_gen').children("option:selected").val()
                   },
                   success: function(data, status, xhr){
                       console.log(data);
                       console.log(typeof data);
                       addMfName(data);
                   }
               })
           }
           function addDrugName(drug_names) {
               var i;
               var opts="<option value=\"-1\" > -- </option>";
               for(i=0; i<drug_names.length; i++){
                   opts += "<option value=" + drug_names[i] +  ">" + drug_names[i] + "</option>"
               }
               $("#drug_name").html(opts);
           }
           function getDrugName() {
                $.ajax({
                   url:"/api/get/drug_names",
                   type:"get",
                   data:{
                       is_generic: $('#is_gen').children("option:selected").val(),
                       mf_name: $('#mf_name').children("option:selected").val()
                   },
                   success: function(data, status, xhr){
                       console.log(data);
                       console.log(typeof data);
                       addDrugName(data);
                   }
               })
           }
           function setDrugID() {
               $.ajax({
                   url:"/api/get/drug_id",
                   type:"get",
                   data:{
                       is_generic: $('#is_gen').children("option:selected").val(),
                       mf_name: $('#mf_name').children("option:selected").val(),
                       drug_name: $('#drug_name').children("option:selected").val()
                   },
                   success: function(data, status, xhr){
                       console.log(data)
                       console.log(typeof data)
                       $('#drug_id').attr('value',data);
                   }
               })
           }
       </script>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>