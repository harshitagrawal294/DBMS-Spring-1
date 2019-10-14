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
import myproject.demo.models.Document;  
@Transactional
@Repository
public class DocumentDao {
@Autowired 
JdbcTemplate template;  
  
// public void setTemplate(JdbcTemplate template) {  
//     this.template = template;  
// }  
public int save(Document p){  
    String sql="insert into Documents(Document_Type,Verification_Status,Link_to_doc,Customer_Id) values('"+p.getDocument_Type()+"',"+0+",'"+p.getLink_to_doc()+"',"+p.getCustomer_Id()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  
public int deleteDocument(int c)
{
    String sql="delete from Documents where Document_Id="+c+"";  
    return template.update(sql);  
}
public int editstatus(int c)
{
    String sql="update Documents set Verification_Status=1-Verification_Status where Document_Id="+c+"";
    return template.update(sql);
}
public int getcbyd(int a)
{
    String sql="select Customer_Id from Documents where Document_Id=?";
    return template.queryForObject(sql,new Object[]{a},Integer.class);
}
public List<Document> getdocbyid(int id){  
    return template.query("select * from Documents where Customer_Id=?",new Object[]{id},new RowMapper<Document>(){  
        public Document mapRow(ResultSet rs, int row) throws SQLException {  
        	Document e=new Document();  
            e.setDocument_Id(rs.getInt(1));  
            e.setDocument_Type(rs.getString(2));
            e.setVerification_Status(rs.getInt(3));
            e.setLink_to_doc(rs.getString(4));
            e.setCustomer_Id(rs.getInt(5));
            return e;  
        }  
    });  
}  
public List<Document> getdocs(){  
    return template.query("select * from Documents ",new RowMapper<Document>(){  
        public Document mapRow(ResultSet rs, int row) throws SQLException {  
        	Document e=new Document();  
            e.setDocument_Id(rs.getInt(1));  
            e.setDocument_Type(rs.getString(2));
            e.setVerification_Status(rs.getInt(3));
            e.setLink_to_doc(rs.getString(4));
            e.setCustomer_Id(rs.getInt(5));
            return e;  
        }  
    });  
}    

}  