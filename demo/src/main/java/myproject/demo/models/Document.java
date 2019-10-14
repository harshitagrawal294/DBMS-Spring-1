package myproject.demo.models;
// import java.util.List;


/**
 * The persistent class for the Documents database table.
 * 
 */



public class Document  {
	// private static final long serialVersionUID = 1L;

	
	
	private int document_Id;

	
	private String document_Type;

	private String Link_to_doc;
	private int verification_Status;
	private int Customer_Id;
	//bi-directional many-to-many association to Customer_Policy
	
	
		
	

	public Document() {
	}

	public int getDocument_Id() {
		return this.document_Id;
	}

	public void setDocument_Id(int document_Id) {
		this.document_Id = document_Id;
	}

	public String getLink_to_doc() {
		return this.Link_to_doc;
	}

	public void setLink_to_doc(String Link_to_doc) {
		this.Link_to_doc=Link_to_doc;
	}

	public String getDocument_Type() {
		return this.document_Type;
	}

	public void setDocument_Type(String document_Type) {
		this.document_Type = document_Type;
	}

	public int getVerification_Status() {
		return this.verification_Status;
	}

	public void setVerification_Status(int verification_Status) {
		this.verification_Status = verification_Status;
	}

	public int getCustomer_Id()
	{
		return this.Customer_Id;
	}
	public void setCustomer_Id(int Customer_Id)
	{
		this.Customer_Id=Customer_Id;
	}

}
