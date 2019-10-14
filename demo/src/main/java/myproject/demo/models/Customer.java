package myproject.demo.models;
import java.util.List;


public class Customer  {
	
	private int customer_Id;

	
	
	private String country;

	
	private String name;


	
	private String pincode;

	private String street;

	private String username;

	//bi-directional many-to-one association to Customer_Contact
	
	private List<Customer_Contact> customerContacts;

	//bi-directional many-to-one association to Customer_Email_Id
	
	private List<Customer_Email_Id> customerEmailIds;

	//bi-directional many-to-one association to Customer_Policy
	
	private List<Customer_Policy> customerPolicies;

	//bi-directional many-to-one association to Document
	
	private List<Document> documents;

	//bi-directional many-to-one association to Relation
	
	private List<Relation> relations1;

	//bi-directional many-to-one association to Relation
	
	private List<Relation> relations2;

	//bi-directional many-to-one association to Wallet
	
	private List<Wallet> wallets;

	public Customer() {
	}

	public int getCustomer_Id() {
		return this.customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String country) {
		this.username = country;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public String getName() {
	// 	return this.name;
	// }

	// public void setName(String name) {
	// 	this.name = name;
	// }

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

	public List<Customer_Contact> getCustomerContacts() {
		return this.customerContacts;
	}

	public void setCustomerContacts(List<Customer_Contact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	

	public List<Customer_Email_Id> getCustomerEmailIds() {
		return this.customerEmailIds;
	}

	public void setCustomerEmailIds(List<Customer_Email_Id> customerEmailIds) {
		this.customerEmailIds = customerEmailIds;
	}

	// public Customer_Email_Id addCustomerEmailId(Customer_Email_Id customerEmailId) {
	// 	getCustomerEmailIds().add(customerEmailId);
	// 	customerEmailId.setCustomer(this);

	// 	return customerEmailId;
	// }

	// public Customer_Email_Id removeCustomerEmailId(Customer_Email_Id customerEmailId) {
	// 	getCustomerEmailIds().remove(customerEmailId);
	// 	customerEmailId.setCustomer(null);

	// 	return customerEmailId;
	// }

	public List<Customer_Policy> getCustomerPolicies() {
		return this.customerPolicies;
	}

	public void setCustomerPolicies(List<Customer_Policy> customerPolicies) {
		this.customerPolicies = customerPolicies;
	}

	

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	// public Document addDocument(Document document) {
	// 	getDocuments().add(document);
	// 	document.setCustomer(this);

	// 	return document;
	// }

	// public Document removeDocument(Document document) {
	// 	getDocuments().remove(document);
	// 	document.setCustomer(null);

	// 	return document;
	// }

	public List<Relation> getRelations1() {
		return this.relations1;
	}

	public void setRelations1(List<Relation> relations1) {
		this.relations1 = relations1;
	}

	public Relation addRelations1(Relation relations1) {
		getRelations1().add(relations1);
		relations1.setCustomer1(this);

		return relations1;
	}

	public Relation removeRelations1(Relation relations1) {
		getRelations1().remove(relations1);
		relations1.setCustomer1(null);

		return relations1;
	}

	public List<Relation> getRelations2() {
		return this.relations2;
	}

	public void setRelations2(List<Relation> relations2) {
		this.relations2 = relations2;
	}

	public Relation addRelations2(Relation relations2) {
		getRelations2().add(relations2);
		relations2.setCustomer2(this);

		return relations2;
	}

	public Relation removeRelations2(Relation relations2) {
		getRelations2().remove(relations2);
		relations2.setCustomer2(null);

		return relations2;
	}

	public List<Wallet> getWallets() {
		return this.wallets;
	}

	public void setWallets(List<Wallet> wallets) {
		this.wallets = wallets;
	}

	// public Wallet addWallet(Wallet wallet) {
	// 	getWallets().add(wallet);
	// 	wallet.setCustomer(this);

	// 	return wallet;
	// }

	// public Wallet removeWallet(Wallet wallet) {
	// 	getWallets().remove(wallet);
	// 	wallet.setCustomer(null);

	// 	return wallet;
	// }

}
