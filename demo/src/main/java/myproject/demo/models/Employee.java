package myproject.demo.models;
// import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Employee database table.
 * 
 */


public class Employee  {
	// private static final long serialVersionUID = 1L;

	
	
	private int user_Id;

	
	private String contact_Information;

	
	private String country;

	
	
	private String date_of_joining;

	
	private String gender;

	
	private String name;

	
	private String pincode;

	
	private String street;

	private int identification;
	private int Office_Id;
	private String username;

	//bi-directional many-to-one association to Customer_Policy
	
	private List<Customer_Policy> customerPolicies;

	//bi-directional many-to-one association to Employee_type
	
	
	// private Employee_type employeeType;

	//bi-directional many-to-one association to Office
	
	
	// private Office office;

	//bi-directional many-to-one association to Feedback
	
	private List<Feedback> feedbacks;

	//bi-directional many-to-many association to Employee
	
	
	
	private List<Employee> employees1;

	//bi-directional many-to-many association to Employee
	
	private List<Employee> employees2;

	public Employee() {
	}

	public int getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}
	public int getOffice_Id() {
		return this.Office_Id;
	}

	public void setOffice_Id(int Office_Id) {
		this.Office_Id = Office_Id;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String country) {
		this.username = country;
	}

	public String getContact_Information() {
		return this.contact_Information;
	}

	public void setContact_Information(String contact_Information) {
		this.contact_Information = contact_Information;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate_of_joining() {
		return this.date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Customer_Policy> getCustomerPolicies() {
		return this.customerPolicies;
	}

	public void setCustomerPolicies(List<Customer_Policy> customerPolicies) {
		this.customerPolicies = customerPolicies;
	}

	

	

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	

	public List<Employee> getEmployees1() {
		return this.employees1;
	}

	public void setEmployees1(List<Employee> employees1) {
		this.employees1 = employees1;
	}

	public List<Employee> getEmployees2() {
		return this.employees2;
	}

	public void setEmployees2(List<Employee> employees2) {
		this.employees2 = employees2;
	}

}
