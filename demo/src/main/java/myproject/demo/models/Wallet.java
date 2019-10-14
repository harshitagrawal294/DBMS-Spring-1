package myproject.demo.models;


/**
 * The persistent class for the Wallet database table.
 * 
 */


public class Wallet  {
	// private static final long serialVersionUID = 1L;

	
	
	private int wallet_id;

	
	private float balance;

	//bi-directional many-to-one association to Customer
	
	
	private int Customer_Id;

	public Wallet() {
	}

	public int getWallet_id() {
		return this.wallet_id;
	}

	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getCustomer_Id() {
		return this.Customer_Id;
	}

	public void setCustomer_Id(int Customer_Id) {
		this.Customer_Id = Customer_Id;
	}

	// public Customer getCustomer() {
	// 	return this.customer;
	// }

	// public void setCustomer(Customer customer) {
	// 	this.customer = customer;
	// }

}
