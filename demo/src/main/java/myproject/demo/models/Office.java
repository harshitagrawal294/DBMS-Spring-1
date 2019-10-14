package myproject.demo.models;
// import java.util.List;


/**
 * The persistent class for the Office database table.
 * 
 */


public class Office  {
	// private static final long serialVersionUID = 1L;

	
	
	private int office_Id;

	private String office_name;
	
	private String contact;

	
	private String country;

	
	

	
	private String pincode;

	
	private String street;



	public Office() {
	}

	public int getOffice_Id() {
		return this.office_Id;
	}

	public void setOffice_Id(int office_Id) {
		this.office_Id = office_Id;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOffice_name() {
		return this.office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
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

	

}
