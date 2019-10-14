package myproject.demo.models;
/**
 * The primary key class for the Relations database table.
 * 
 */

public class RelationPK  {
	//default serial version id, required for serializable classes.
	// private static final long serialVersionUID = 1L;

	
	private int customer_Id;

	
	private int customersRelation_Id;

	public RelationPK() {
	}
	public int getCustomer_Id() {
		return this.customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public int getCustomersRelation_Id() {
		return this.customersRelation_Id;
	}
	public void setCustomersRelation_Id(int customersRelation_Id) {
		this.customersRelation_Id = customersRelation_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelationPK)) {
			return false;
		}
		RelationPK castOther = (RelationPK)other;
		return 
			(this.customer_Id == castOther.customer_Id)
			&& (this.customersRelation_Id == castOther.customersRelation_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customer_Id;
		hash = hash * prime + this.customersRelation_Id;
		
		return hash;
	}
}
