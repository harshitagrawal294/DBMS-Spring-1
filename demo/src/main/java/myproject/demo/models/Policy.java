package myproject.demo.models;
import java.util.List;


/**
 * The persistent class for the Policy database table.
 * 
 */


public class Policy  {
	// private static final long serialVersionUID = 1L;

	
	
	private int policy_id;

	
	private float cost_per_month;

	
	private String name_of_Policy;

	
	private String type;

	private String thingscov;

	private int Company_Id;

	//bi-directional many-to-one association to Customer_Policy
	
	private List<Customer_Policy> customerPolicies;

	//bi-directional many-to-one association to Company
	
	
	// private Company company;

	//bi-directional many-to-one association to Policy_Things_covered
	


	public Policy() {
	}

	public int getPolicy_id() {
		return this.policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	public int getCompany_Id() {
		return this.Company_Id;
	}

	public void setCompany_Id(int policy_id) {
		this.Company_Id = policy_id;
	}

	public float getCost_per_month() {
		return this.cost_per_month;
	}

	public void setCost_per_month(float cost_per_month) {
		this.cost_per_month = cost_per_month;
	}

	public String getName_of_Policy() {
		return this.name_of_Policy;
	}

	public void setName_of_Policy(String name_of_Policy) {
		this.name_of_Policy = name_of_Policy;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getThingscover() {
		return this.thingscov;
	}

	public void setThingscover(String type) {
		this.thingscov = type;
	}

	public List<Customer_Policy> getCustomerPolicies() {
		return this.customerPolicies;
	}

	public void setCustomerPolicies(List<Customer_Policy> customerPolicies) {
		this.customerPolicies = customerPolicies;
	}

	



}
