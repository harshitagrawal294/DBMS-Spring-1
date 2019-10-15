package myproject.demo.models;

/**
 * The persistent class for the Relations database table.
 * 
 */



public class Transaction {
    // private static final long serialVersionUID = 1L;

    private int transactionid;
    private float money;
    private int status;

    
    private int User_Id;
    private int Customer_Id;
    
    public int getTransactionid() {
        return this.transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public float getMoney() {
        return this.money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_Id() {
        return this.User_Id;
    }

    public void setUser_Id(int User_Id) {
        this.User_Id = User_Id;
    }

    public int getCustomer_Id() {
        return this.Customer_Id;
    }

    public void setCustomer_Id(int Customer_Id) {
        this.Customer_Id = Customer_Id;
    }

}
