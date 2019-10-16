package myproject.demo.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myproject.demo.models.Customer;  

@Transactional
@Repository
public class CustomerDao { 
    @Autowired
    JdbcTemplate template;
  
// public void setTemplate(JdbcTemplate template) {  
//     this.template = template;  
// }  
    public int save(Customer p){
        String sql="insert into Customer(Name,Street,Pincode,Country,username) values('"+p.getName()+"','"+p.getStreet()+"','"+p.getPincode()+"','"+p.getCountry()+"','"+p.getUsername()+"')";
        // System.out.print(sql);
        return template.update(sql);
    }
    public boolean userExist(String username) {
        String sql = "select count(*) from Customer where username=?";
        int p = template.queryForObject(sql, Integer.class, username);
        if (p == 0)
            return false;
        else
            return true;
    }
    public int getlastcustomer()
    {
        String sql="select Customer_Id from Customer where Customer_Id >= all(select p.Customer_Id from Customer as p)";
        return template.queryForObject(sql,Integer.class);
    }
    public int updateName(Customer p){
        String sql="update Customer set Name="+p.getName()+" where Customer_Id="+p.getCustomer_Id();
        return template.update(sql);
    }
    public int updateStreet(Customer p){
        String sql="update Customer set street="+p.getStreet()+" where Customer_Id="+p.getCustomer_Id();
        return template.update(sql);
    }
    public int updateCountry(Customer p){
        String sql="update Customer set Country="+p.getCountry()+" where Customer_Id="+p.getCustomer_Id();
        return template.update(sql);
    }
    public int updatepincode(Customer p){
        String sql="update Customer set Pincode="+p.getPincode()+" where Customer_Id="+p.getCustomer_Id();
        return template.update(sql);
    }
    public int delete(int id){
        String sql="delete from Customer where Customer_Id="+id+"";
        return template.update(sql);
    }
    public Customer getCustomerById(int id){
        String sql="select * from Customer where Customer_Id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));
    }
    public Customer getCustomerByusername(String username){
        String sql="select * from Customer where username=?";
        return template.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<Customer>(Customer.class));
    }
    public String namebyid(int id){
        String sql="select Name from Customer where Customer_Id=?";
        return template.queryForObject(sql, new Object[]{id},String.class);
    }
    public List<Customer> getCustomer(){
        return template.query("select * from Customer",new RowMapper<Customer>(){
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer e=new Customer();
                e.setCustomer_Id(rs.getInt("Customer_Id"));
                e.setName(rs.getString("Name"));
                e.setStreet(rs.getString("street"));
                e.setCountry(rs.getString("Country"));
                e.setPincode(rs.getString("Pincode"));
                e.setUsername(rs.getString("username"));
                return e;
            }
        });
    }

    public List<Customer> getAllCustomer(){
        String query = "select * from Customer";
        return template.query(query, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer e=new Customer();
                e.setCustomer_Id(rs.getInt("Customer_Id"));
                e.setName(rs.getString("Name"));
                e.setStreet(rs.getString("street"));
                e.setCountry(rs.getString("Country"));
                e.setPincode(rs.getString("Pincode"));
                e.setUsername(rs.getString("username"));
                return e;
            }
        });
    }
}  