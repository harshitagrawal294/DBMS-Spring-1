package myproject.demo.dao;

import java.sql.ResultSet;

// import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import javax.transaction.Transactional;

// import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// import myproject.demo.models.Office;
import myproject.demo.models.Policy;
// import myproject.demo.models.Wallet; 
@Transactional
@Repository
public class PolicyDao {
@Autowired 
JdbcTemplate template;  



  
 
public int savenew(Policy p) {
    String sql="insert into Policy(Name_of_Policy,Cost_per_month,type,Company_Id,things_to_cover) values('"+p.getName_of_Policy()+"',"+p.getCost_per_month()+",'"+p.getType()+"',"+p.getCompany_Id()+",'"+p.getThingscover()+"')";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int c){  
    String sql="delete from Policy where Policy_id="+c+"";  
    return template.update(sql);  
}  
public int update(Policy p)
{
    String sql="update Policy set Policy_id="+p.getPolicy_id()+",Name_of_Policy='"+p.getName_of_Policy()+"',Cost_per_month="+p.getCost_per_month()+",type='"+p.getType()+"',Company_Id="+p.getCompany_Id()+",things_to_cover='"+p.getThingscover()+"' where Policy_id="+p.getPolicy_id()+"";
    return template.update(sql);
}
public String getnamebyid(int id){
    String sql="select Name_of_Policy from Policy where Policy_id=?";
    return template.queryForObject(sql, new Object[]{id}, String.class);
}
public int getbalancebyid(int id){
    String sql="select Cost_per_month from Policy where Policy_id=?";
    return template.queryForObject(sql, new Object[]{id}, Integer.class);
}
public int getCompanybyid(int id){
    String sql="select Company_Id from Policy where Policy_id=?";
    return template.queryForObject(sql, new Object[]{id}, Integer.class);
}
public List<Policy> getPolicy(){  
    return template.query("select * from Policy",new RowMapper<Policy>(){  
        public Policy mapRow(ResultSet rs, int row) throws SQLException {  
        	Policy e=new Policy();  
            e.setPolicy_id(rs.getInt(1));  
            e.setName_of_Policy(rs.getString(2));  
            e.setCost_per_month(rs.getInt(3));
            e.setThingscover(rs.getString(4));
            e.setType(rs.getString(5));
            e.setCompany_Id(rs.getInt(6));
            return e;  
        }  
    });  
}  
public List<Policy> getpolicybycompany(int id){  
    return template.query("select * from Policy where Company_Id=?",new Object[]{id},new RowMapper<Policy>(){  
        public Policy mapRow(ResultSet rs, int row) throws SQLException {  
        	Policy e=new Policy();  
            e.setPolicy_id(rs.getInt(1));  
            e.setName_of_Policy(rs.getString(2));  
            e.setCost_per_month(rs.getInt(3));
            e.setThingscover(rs.getString(4));
            e.setType(rs.getString(5));
            e.setCompany_Id(rs.getInt(6));
            return e;  
        }  
    });  
}  
public List<Policy> getpolicybytype(String type){
    return template.query("select * from Policy where type=?",new Object[]{type},new RowMapper<Policy>(){
        public Policy mapRow(ResultSet rs, int row) throws SQLException {  
        	Policy e=new Policy();  
            e.setPolicy_id(rs.getInt(1));  
            e.setName_of_Policy(rs.getString(2));  
            e.setCost_per_month(rs.getInt(3));
            e.setThingscover(rs.getString(4));
            e.setType(rs.getString(5));
            e.setCompany_Id(rs.getInt(6));
            return e;  
        }  
    });  
}  


}  