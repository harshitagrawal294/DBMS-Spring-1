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

// import myproject.demo.models.Customer_Contact;
import myproject.demo.models.Policy_Things_covered;;  
@Transactional
@Repository
public class policythingsDao {
@Autowired 
JdbcTemplate template;  



  
 
public int save(Policy_Things_covered p) {
    String sql="insert into Policy_Things_covered(Things_covered,Policy_id) values('"+p.getThings_Covered()+"',"+p.getPolicy_Id()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int id,String c){  
    String sql="delete from Policy_Things_covered where Policy_id="+id+" and Things_covered='"+c+"'";  
    return template.update(sql);  
}  

public List<Policy_Things_covered> getthingsforpolicy(int id){  
    return template.query("select * from Policy_Things_covered where Policy_id=?",new Object[]{id},new RowMapper<Policy_Things_covered>(){  
        public Policy_Things_covered mapRow(ResultSet rs, int row) throws SQLException {  
        	Policy_Things_covered e=new Policy_Things_covered();  
            e.setThings_Covered(rs.getString(1));
            e.setPolicy_Id(rs.getInt(2));
            return e;  
        }  
    });  
}  
}  