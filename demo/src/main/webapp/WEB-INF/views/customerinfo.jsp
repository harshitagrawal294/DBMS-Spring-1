<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Customer Info</h1>

<p>User name= ${cust.getUsername() }</p>
<p>Name= ${cust.getName()}</p>
<p>Street= ${cust.getStreet()}</p>
<p>Pincode= ${cust.getPincode()}</p>
<p>Country= ${cust.getCountry()}</p>
<p><a href="/customer/deletecustomer">Delete</a></p>
<p><a href="/customer/showcontact">Show Contacts</a></p>
<p><a href="/customer/addcontact">Add Contacts</a></p>
<p><a href="/customer/showemails">Show Emails</a></p>
<p><a href="/customer/addemails">Add Emails</a></p>
<p>Wallet Balance= ${balance}</p>
<p><a href="/customer/addbalance">Add balance</a></p>
<br/>
<!-- <a href="/customer/customerform">Add New Customer</a> -->