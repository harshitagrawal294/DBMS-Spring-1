package myproject.demo.models;

/**
 * The primary key class for the Policy_Things_covered database table.
 * 
 */

public class Policy_Things_covered {
	// default serial version id, required for serializable classes.
	// private static final long serialVersionUID = 1L;

	private String Things_Covered;

	private int Policy_Id;

	public Policy_Things_covered() {
	}

	public String getThings_Covered() {
		return this.Things_Covered;
	}

	public void setThings_Covered(String things_covered) {
		this.Things_Covered = things_covered;
	}

	public int getPolicy_Id() {
		return this.Policy_Id;
	}

	public void setPolicy_Id(int policy_id) {
		this.Policy_Id = policy_id;
	}

	
}
