package myproject.demo.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// import myproject.demo.models.Customer;
// import myproject.demo.models.Employee;
import myproject.demo.models.Feedback;  
@Transactional
@Repository
public class FeedbackDao {
@Autowired 
JdbcTemplate template;  
  
// public void setTemplate(JdbcTemplate template) {  
//     this.template = template;  
// }  
public int save(Feedback p){  
    String sql="insert into Feedback(Remarks,User_Id) values('"+p.getRemarks()+"',"+p.getUser_Id()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Feedback where Serial_Number ="+id+"";  
    return template.update(sql);  
}  
public int update(Feedback p){
    String sql="update Feedback set Remarks='"+p.getRemarks()+"',User_Id="+p.getUser_Id()+" where Serial_Number="+p.getSerial_Number()+"";
    return template.update(sql);
}
public List<Feedback> getFeedback(){  
    return template.query("select * from Feedback",new RowMapper<Feedback>(){  
        public Feedback mapRow(ResultSet rs, int row) throws SQLException {  
        	Feedback e=new Feedback();  
            e.setRemarks(rs.getString(1));
            e.setSerial_Number(rs.getInt(2));
            e.setUser_Id(rs.getInt(3));
            return e;  
        }  
    });  
}  
public List<Feedback> getFeedbackforuser(int id){  
    return template.query("select * from Feedback where User_Id=?",new Object[]{id},new RowMapper<Feedback>(){  
        public Feedback mapRow(ResultSet rs, int row) throws SQLException {  
        	Feedback e=new Feedback();  
            e.setRemarks(rs.getString(1));
            e.setSerial_Number(rs.getInt(2));
            e.setUser_Id(rs.getInt(3));
            return e;  
        }  
    });  
}  
}  