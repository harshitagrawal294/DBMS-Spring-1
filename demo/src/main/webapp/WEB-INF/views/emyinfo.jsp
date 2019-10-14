<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Employee Info</h1>

<p>User name= ${cust.getUsername() }</p>
<p>Name= ${cust.getName()}</p>
<p>Date of Joining= ${cust.getDate_of_joining()}</p>
<p>Contact= ${cust.getContact_Information()}</p>
<p>Gender= ${cust.getGender()}</p>
<p>Street= ${cust.getStreet()}</p>
<p>Pincode= ${cust.getPincode()}</p>
<p>Country= ${cust.getCountry()}</p>
<p>Employee type= ${etype}</p>
<p>Office= ${office}</p>

<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->