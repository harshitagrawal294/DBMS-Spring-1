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

import myproject.demo.models.Customer_Contact;;  
@Transactional
@Repository
public class CustomerContactsDao {
@Autowired 
JdbcTemplate template;  



  
 
public int save(Customer_Contact p) {
    String sql="insert into Customer_Contact(Contact,Customer_Id) values('"+p.getContact()+"',"+p.getCustomer_Id()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int id,String c){  
    String sql="delete from Customer_Contact where Customer_Id="+id+" and Contact='"+c+"'";  
    return template.update(sql);  
}  

public List<Customer_Contact> getCustomerContacts(int id){  
    return template.query("select * from Customer_Contact where Customer_Id=?",new Object[]{id},new RowMapper<Customer_Contact>(){  
        public Customer_Contact mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer_Contact e=new Customer_Contact();  
            e.setContact(rs.getString(1));
            e.setCustomer_Id(rs.getInt(2));
            return e;  
        }  
    });  
}  
}  