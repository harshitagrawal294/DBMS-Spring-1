package myproject.demo.models;


/**
 * The persistent class for the Feedback database table.
 * 
 */


public class Feedback  {
	// private static final long serialVersionUID = 1L;

	
	
	private int Serial_Number;

	
	private String Remarks;

	
	private int User_Id;

	public Feedback() {
	}

	public int getSerial_Number() {
		return this.Serial_Number;
	}

	public void setSerial_Number(int serial_Number) {
		this.Serial_Number = serial_Number;
	}

	public String getRemarks() {
		return this.Remarks;
	}

	public void setRemarks(String remarks) {
		this.Remarks = remarks;
	}

	public int getUser_Id() {
		return this.User_Id;
	}
	public void setUser_Id(int id){
		this.User_Id=id;
	}

	
}
