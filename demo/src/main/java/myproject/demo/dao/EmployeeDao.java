package myproject.demo.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// import myproject.demo.models.Customer;
import myproject.demo.models.Employee;  
@Transactional
@Repository
public class EmployeeDao {
@Autowired 
JdbcTemplate template;  
  
// public void setTemplate(JdbcTemplate template) {  
//     this.template = template;  
// }  
public int save(Employee p){  
    String sql="insert into Employee(Name,Date_of_joining,Street,Contact_Information,Gender,Pincode,Country,Identification,Office_Id,username) values('"+p.getName()+"','"+p.getDate_of_joining()+"','"+p.getStreet()+"','"+p.getContact_Information()+"','"+p.getGender()+"','"+p.getPincode()+"','"+p.getCountry()+"',"+p.getIdentification()+","+p.getOffice_Id()+",'"+p.getUsername()+"')";  
    // System.out.print(sql);
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Employee where User_Id ="+id+"";  
    return template.update(sql);  
}  
public Employee getemployeeByusername(String username){  
    String sql="select * from Employee where username=?";  
    return template.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<Employee>(Employee.class));  
} 
public String getoffice(int id){  
    String sql="select Office_name from Employee as e,Office as o where User_Id=? and o.Office_Id=e.Office_Id";  
    return template.queryForObject(sql, new Object[]{id},String.class);  
} 
public String getetype(int id){  
    String sql="select o.Type from Employee as e,Employee_type as o where User_Id=? and o.Identification=e.Identification";  
    return template.queryForObject(sql, new Object[]{id},String.class);  
} 
public boolean userExist(String username) {
    String sql = "select count(*) from Employee where username=?";
    int p = template.queryForObject(sql, Integer.class, username);
    if (p == 0)
        return false;
    else
        return true;
}
public int update(Employee p){
    String sql="update Employee set Name='"+p.getName()+"',Date_of_joining='"+p.getDate_of_joining()+"',Street='"+p.getStreet()+"',Contact_Information='"+p.getContact_Information()+"',Gender='"+p.getGender()+"',Pincode='"+p.getPincode()+"',Country='"+p.getCountry()+"',Identification="+p.getIdentification()+",Office_Id="+p.getOffice_Id()+" where User_Id="+p.getUser_Id()+",username='"+p.getUsername()+"'";
    return template.update(sql);
}
public int updateoffice(Employee p){
    String sql="update Employee set Office_Id="+p.getOffice_Id()+"  where User_Id="+p.getUser_Id()+"";
    return template.update(sql);
}
public int updateemptype(Employee p){
    String sql="update Employee set Identification="+p.getIdentification()+"  where User_Id="+p.getUser_Id()+"";
    return template.update(sql);
}
public Employee getEmployeeById(int id){  
    String sql="select * from Employee where User_Id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));  
}  
  
public List<Employee> getEmployee(){  
    return template.query("select * from Employee",new RowMapper<Employee>(){  
        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
        	Employee e=new Employee();  
            e.setName(rs.getString(1));
            e.setUser_Id(rs.getInt(2));
            e.setDate_of_joining(rs.getString(3));
            e.setStreet(rs.getString(4));
            e.setContact_Information(rs.getString(5));
            e.setGender(rs.getString(6));
            e.setPincode(rs.getString(7));
            e.setCountry(rs.getString(8));
            e.setIdentification(rs.getInt(9));
            e.setOffice_Id(rs.getInt(10));
            e.setUsername(rs.getString(11));
            return e;  
        }  
    });  
}  
}  