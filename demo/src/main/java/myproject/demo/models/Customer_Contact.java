package myproject.demo.models;

/**
 * The primary key class for the Customer_Contact database table.
 * 
 */

public class Customer_Contact {
	// default serial version id, required for serializable classes.
	// private static final long serialVersionUID = 1L;

	private String contact;

	private int customer_Id;

	public Customer_Contact() {
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getCustomer_Id() {
		return this.customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	
}
