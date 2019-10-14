package myproject.demo.models;
// 
// import java.util.List;


public class Asset  {
	
	private int assetid;
	private String details;
	private String type;
	private int policynumber;
	private int customerid;
	


	public int getAssetid() {
		return this.assetid;
	}

	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String details) {
		this.type = details;
	}

	public int getPolicynumber() {
		return this.policynumber;
	}

	public void setPolicynumber(int policynumber) {
		this.policynumber = policynumber;
	}

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
}
