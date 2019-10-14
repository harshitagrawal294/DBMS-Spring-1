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

import myproject.demo.models.Office;
// import myproject.demo.models.Wallet; 
@Transactional
@Repository
public class OfficeDao {
@Autowired 
JdbcTemplate template;  



  
 
public int savenew(Office p) {
    String sql="insert into Office(Office_name,Street,Contact,Pincode,Country) values('"+p.getOffice_name()+"','"+p.getStreet()+"','"+p.getContact()+"','"+p.getPincode()+"','"+p.getCountry()+"')";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int c){  
    String sql="delete from Office where Office_Id="+c+"";  
    return template.update(sql);  
}  
public int update(Office p)
{
    String sql="update Office set Office_name='"+p.getOffice_name()+"',Street='"+p.getStreet()+"',Contact='"+p.getContact()+"',Pincode='"+p.getPincode()+"',Country='"+p.getCountry()+"' where Office_Id="+p.getOffice_Id()+"";
    return template.update(sql);
}
public String getnamebyid(int id){
    String sql="select Office_name from Office where Office_Id=?";
    return template.queryForObject(sql, new Object[]{id}, String.class);
}
public List<Office> getOffice(){  
    return template.query("select * from Office",new RowMapper<Office>(){  
        public Office mapRow(ResultSet rs, int row) throws SQLException {  
        	Office e=new Office();  
            e.setOffice_Id(rs.getInt(1));  
            e.setOffice_name(rs.getString(2));  
            e.setStreet(rs.getString(3));
            e.setContact(rs.getString(4));
            e.setPincode(rs.getString(5));
            e.setCountry(rs.getString(6));
            return e;  
        }  
    });  
}  

}  