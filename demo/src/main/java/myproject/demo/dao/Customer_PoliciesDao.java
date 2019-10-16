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

// import myproject.demo.models.Customer;
import myproject.demo.models.Customer_Policy;  
@Transactional
@Repository
public class Customer_PoliciesDao {
@Autowired 
JdbcTemplate template;  
  
// public void setTemplate(JdbcTemplate template) {  
//     this.template = template;  
// }  
public int save(Customer_Policy p){  
    String sql="insert into Customer_Policies(Date_of_Purchase,date_of_expire,Policy_id,Customer_Id,Asset_Id) values(curdate(),DATE_ADD(curdate(), INTERVAL 30 DAY),"+p.getPolicy_Id()+","+p.getCustomer_Id()+","+p.getAsset_Id()+")";
    return template.update(sql);  
}  
public int getlast(){
    return template.queryForObject("select distinct(Customer_Id) from Customer_Policies where Policy_Number >= all (select Policy_Number from Customer_Policies);", Integer.class);
}
public int getcustomerbyid(int id){
    return template.queryForObject("select Customer_Id from Customer_Policies where Policy_Number=?",new Object[]{id}, Integer.class);
}

public int delete(int id){  
    String sql="delete from Customer_Policies where Policy_Number="+id+"";  
    return template.update(sql);  
}
  
public List<Customer_Policy> getPolicy(){  
    return template.query("select * from Customer_Policies",new RowMapper<Customer_Policy>(){  
        public Customer_Policy mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer_Policy e=new Customer_Policy();  
            e.setPolicy_Number(rs.getInt(1));  
            e.setDate_of_Purchase(rs.getString(2));  
            e.setDateOfExpire(rs.getString(3));
            e.setPolicy_Id(rs.getInt(4));
            // e.setUser_Id(rs.getInt(5));
            e.setCustomer_Id(rs.getInt(6));
            return e;  
        }  
    });  
}  
public List<Customer_Policy> getpolicybycustomer(int id){  
    return template.query("select * from Customer_Policies where Customer_Id=?",new Object[]{id},new RowMapper<Customer_Policy>(){  
        public Customer_Policy mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer_Policy e=new Customer_Policy();  
            e.setPolicy_Number(rs.getInt(1));  
            e.setDate_of_Purchase(rs.getString(2));  
            e.setDateOfExpire(rs.getString(3));
            e.setPolicy_Id(rs.getInt(4));
            // e.setUser_Id(rs.getInt(5));
            e.setCustomer_Id(rs.getInt(6));
            return e;  
        }  
    });  
}

public void discontinueByAssetId(int asset_id){
    String query = "update Customer_Policies set date_of_expire=subdate(curdate(),1) where Asset_Id="+asset_id;
    template.update(query);
}

public int getPolicyNumber(int customer_id, int asset_id){
    String query = "select Policy_Number from Customer_Policies where Customer_Id=? and Asset_Id=?";
    return template.queryForObject(query, new Object[]{customer_id, asset_id}, Integer.class);
}
}  