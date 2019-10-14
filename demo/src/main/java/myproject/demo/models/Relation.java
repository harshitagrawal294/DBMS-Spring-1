package myproject.demo.models;

/**
 * The persistent class for the Relations database table.
 * 
 */



public class Relation  {
	// private static final long serialVersionUID = 1L;

	
	private RelationPK id;

	
	private String relationship_Type;

	//bi-directional many-to-one association to Customer
	
	
	private Customer customer1;

	//bi-directional many-to-one association to Customer
	
	
	private Customer customer2;

	public Relation() {
	}

	public RelationPK getId() {
		return this.id;
	}

	public void setId(RelationPK id) {
		this.id = id;
	}

	public String getRelationship_Type() {
		return this.relationship_Type;
	}

	public void setRelationship_Type(String relationship_Type) {
		this.relationship_Type = relationship_Type;
	}

	public Customer getCustomer1() {
		return this.customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}

	public Customer getCustomer2() {
		return this.customer2;
	}

	public void setCustomer2(Customer customer2) {
		this.customer2 = customer2;
	}

}
