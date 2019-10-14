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
import myproject.demo.models.Employee_type;  
@Transactional
@Repository
public class Employee_typeDao {
@Autowired 
JdbcTemplate template;  
  
// public void setTemplate(JdbcTemplate template) {  
//     this.template = template;  
// }  
public int save(Employee_type p){  
    String sql="insert into Employee_type(Type,Salary) values('"+p.getType()+"',"+p.getSalary()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Employee_type where Identification="+id+"";  
    return template.update(sql);  
}  
public float getSalaryId(int id){  
    String sql="select Salary from Employee_type where Identification=?";  
    return template.queryForObject(sql, new Object[]{id},Float.class);  
}  
public int updatesalary(Employee_type p){
    String sql="update Employee_type set Salary="+p.getSalary()+" where Identification="+p.getIdentification()+"";
    return template.update(sql);
}
public String getnamebyid(int id){
    String sql="select Type from Employee_type where Identification=?";
    return template.queryForObject(sql, new Object[]{id}, String.class);
}
public List<Employee_type> getEmployee_type(){  
    return template.query("select * from Employee_type",new RowMapper<Employee_type>(){  
        public Employee_type mapRow(ResultSet rs, int row) throws SQLException {  
        	Employee_type e=new Employee_type();  
            e.setType(rs.getString(1));  
            e.setSalary(rs.getFloat(2));  
            e.setIdentification(rs.getInt(3));
            return e;  
        }  
    });  
}  
}  