package myproject.demo.models;
// import java.util.List;


/**
 * The persistent class for the Documents database table.
 * 
 */



public class Documentof {
    // private static final long serialVersionUID = 1L;

    private int documentid;

    private int customerid;

    private int policynumber;
    // bi-directional many-to-many association to Customer_Policy

   


    public int getDocumentid() {
        return this.documentid;
    }

    public void setDocumentid(int documentid) {
        this.documentid = documentid;
    }

    public int getCustomerid() {
        return this.customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getPolicynumber() {
        return this.policynumber;
    }

    public void setPolicynumber(int policynumber) {
        this.policynumber = policynumber;
    }
}