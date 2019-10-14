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

import myproject.demo.models.Company;
// import myproject.demo.models.Office;
// import myproject.demo.models.Wallet; 
@Transactional
@Repository
public class CompanyDao {
@Autowired 
JdbcTemplate template;  



  
 
public int savenew(Company p) {
    String sql="insert into Company(Name,Street,Contact_Information,Pincode,Country) values('"+p.getName()+"','"+p.getStreet()+"','"+p.getContact_Information()+"','"+p.getPincode()+"','"+p.getCountry()+"')";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int c){  
    String sql="delete from Company where Company_Id="+c+"";  
    return template.update(sql);  
}  
public int update(Company p)
{
    String sql="update Company set Name='"+p.getName()+"',Street='"+p.getStreet()+"',Contact_Information='"+p.getContact_Information()+"',Pincode='"+p.getPincode()+"',Country='"+p.getCountry()+"' where Company_Id="+p.getCompany_Id()+"";
    return template.update(sql);
}
public String getnamebyid(int id){
    String sql="select Name from Compamy where Company_Id=?";
    return template.queryForObject(sql, new Object[]{id}, String.class);
}
public List<Company> getCompany(){  
    return template.query("select * from Company",new RowMapper<Company>(){  
        public Company mapRow(ResultSet rs, int row) throws SQLException {  
        	Company e=new Company();  
            e.setCompany_Id(rs.getInt(2));  
            e.setName(rs.getString(1));  
            e.setStreet(rs.getString(4));
            e.setContact_Information(rs.getString(3));
            e.setPincode(rs.getString(5));
            e.setCountry(rs.getString(6));
            return e;  
        }  
    });  
}  

}  