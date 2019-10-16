package myproject.demo.models;
// import java.util.Date;


/**
 * The persistent class for the Claim_Details database table.
 * 
 */



public class Claim_Detail  {
	// private static final long serialVersionUID = 1L;

	
	
	private int claim_Id;

	
	private String damage;

	
	
	private String date;

	
	private int status;

	//bi-directional many-to-one association to Customer_Policy
	
	
	private int policy_Number;

	private int customer_Id;
		
		
	

	public Claim_Detail() {
	}
	public int getPolicy_Number() {
		return this.policy_Number;
	}
	public void setPolicy_Number(int policy_Number) {
		this.policy_Number = policy_Number;
	}
	public int getCustomer_Id() {
		return this.customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public int getClaim_Id() {
		return this.claim_Id;
	}

	public void setClaim_Id(int claim_Id) {
		this.claim_Id = claim_Id;
	}

	public String getDamage() {
		return this.damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

}
