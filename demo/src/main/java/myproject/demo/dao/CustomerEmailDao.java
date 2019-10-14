package myproject.demo.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import javax.transaction.Transactional;

// import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myproject.demo.models.Customer_Email_Id;;;  
@Transactional
@Repository
public class CustomerEmailDao {
@Autowired 
JdbcTemplate template;  



  
 
public int save(Customer_Email_Id p) {
    String sql="insert into Customer_Email_Id(Email_Id,Customer_Id) values('"+p.getEmail_Id()+"',"+p.getCustomer_Id()+")";  
    // System.out.print(sql);getEmail_Id 
    return template.update(sql);  
}  

public int delete(int id,String c){  
    String sql="delete from Customer_Email_Id where Customer_Id="+id+" and Email_Id='"+c+"'";  
    return template.update(sql);  
}  

public List<Customer_Email_Id> getCustomerEmail(int id){  
    return template.query("select * from Customer_Email_Id where Customer_Id=?",new Object[]{id},new RowMapper<Customer_Email_Id>(){  
        public Customer_Email_Id mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer_Email_Id e=new Customer_Email_Id();  
            e.setEmail_Id(rs.getString(1));
            e.setCustomer_Id(rs.getInt(2));
            return e;  
        }  
    });  
}  
}  