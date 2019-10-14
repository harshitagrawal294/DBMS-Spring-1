package myproject.demo.models;
// import java.util.List;



public class Employee_type  {
	// private static final long serialVersionUID = 1L;

	
	
	private int identification;

	
	private float salary;

	
	private String type;

	//bi-directional many-to-one association to Employee
	
	// private List<Employee> employees;

	public Employee_type() {
	}

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
