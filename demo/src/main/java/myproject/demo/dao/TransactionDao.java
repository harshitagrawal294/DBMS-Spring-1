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
// import myproject.demo.models.Policy;
import myproject.demo.models.Transaction;
// import myproject.demo.models.Wallet; 
@Transactional
@Repository
public class TransactionDao {
@Autowired 
JdbcTemplate template;  



  
 
public int savebycustomer(Transaction p) {
    String sql="insert into transaction(money,status,Customer_Id) values("+p.getMoney()+","+p.getStatus()+","+p.getCustomer_Id()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  
public int savebyemployee(int id,int eid) {
    String sql="update transaction set status=1-status,User_Id="+eid+" where transactionid="+id+"";  
    // System.out.print(sql);
    return template.update(sql);  
} 
public int getmoney(int id)
{
    String sql="select money from transaction where transactionid=?";
    return template.queryForObject(sql,new Object[]{id},Integer.class);
}
public int getcustomer(int id)
{
    String sql="select Customer_Id from transaction where transactionid=?";
    return template.queryForObject(sql,new Object[]{id},Integer.class);
}

 
public List<Transaction> getpending(){  
    return template.query("select * from transaction where status=0",new RowMapper<Transaction>(){  
        public Transaction mapRow(ResultSet rs, int row) throws SQLException {  
        	Transaction e=new Transaction();  
            e.setMoney(rs.getInt(1));  
            e.setStatus(rs.getInt(2));  
            e.setTransactionid(rs.getInt(5));
            e.setCustomer_Id(rs.getInt(4));
            return e;  
        }  
    });  
}  


}  