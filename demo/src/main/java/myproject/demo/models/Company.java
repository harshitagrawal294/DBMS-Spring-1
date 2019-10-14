package myproject.demo.models;
import java.util.List;


/**
 * The persistent class for the Company database table.
 * 
 */


public class Company  {
	// private static final long serialVersionUID = 1L;

	
	
	private int company_Id;

	
	private String contact_Information;

	
	private String country;

	
	private String name;

	
	private String pincode;

	
	private String street;

	//bi-directional many-to-one association to Policy
	
	private List<Policy> policies;

	public Company() {
	}

	public int getCompany_Id() {
		return this.company_Id;
	}

	public void setCompany_Id(int company_Id) {
		this.company_Id = company_Id;
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

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	

}
