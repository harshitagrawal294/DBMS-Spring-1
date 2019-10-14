package myproject.demo.models;
/**
 * The primary key class for the Customer_Email_Id database table.
 * 
 */

public class Customer_Email_Id {
	//default serial version id, required for serializable classes.
	// private static final long serialVersionUID = 1L;

	
	private String Email_Id;

	
	private int Customer_Id;

	public Customer_Email_Id() {
	}
	public String getEmail_Id() {
		return this.Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.Email_Id = email_Id;
	}
	public int getCustomer_Id() {
		return this.Customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.Customer_Id = customer_Id;
	}
	public String getContact() {
		return null;
	}

	
}
