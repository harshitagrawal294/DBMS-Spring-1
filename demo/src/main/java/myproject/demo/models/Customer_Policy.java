package myproject.demo.models;

// import java.util.Date;

/**
 * The primary key class for the Customer_Policies database table.
 * 
 */

public class Customer_Policy {
	// default serial version id, required for serializable classes.
	// private static final long serialVersionUID = 1L;

	private int policy_Number;

	private int customer_Id;

	private String dateOfExpire;

	private String date_of_Purchase;

	private int Policy_Id;
	private int User_Id;

	public Customer_Policy() {
	}
	public int getPolicy_Number() {
		return this.policy_Number;
	}
	public void setPolicy_Number(int policy_Number) {
		this.policy_Number = policy_Number;
	}
	public String getDateOfExpire() {
		return this.dateOfExpire;
	}

	public void setDateOfExpire(String dateOfExpire) {
		this.dateOfExpire = dateOfExpire;
	}

	public String getDate_of_Purchase() {
		return this.date_of_Purchase;
	}

	public void setDate_of_Purchase(String date_of_Purchase) {
		this.date_of_Purchase = date_of_Purchase;
	}
	public int getCustomer_Id() {
		return this.customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public int getPolicy_Id() {
		return this.Policy_Id;
	}
	public void setPolicy_Id(int Policy_Id) {
		this.Policy_Id = Policy_Id;
	}
	public int getUser_Id() {
		return this.User_Id;
	}
	public void setUser_Id(int User_Id) {
		this.User_Id = User_Id;
	}
}
