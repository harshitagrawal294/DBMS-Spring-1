package myproject.demo.dao;

// import java.sql.ResultSet;  
// import java.sql.SQLException;  
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import javax.transaction.Transactional;

// import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
// import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myproject.demo.models.Wallet; 
@Transactional
@Repository
public class WalletDao {
@Autowired 
JdbcTemplate template;  



  
 
public int savenew(int c) {
    String sql="insert into Wallet(Balance,Customer_Id) values("+0+","+c+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int c){  
    String sql="delete from Wallet where Customer_Id="+c+"";  
    return template.update(sql);  
}  
public int update(Wallet p)
{
    String sql="update Wallet set Balance=Balance+"+p.getBalance()+" where Customer_Id="+p.getCustomer_Id()+"";
    return template.update(sql);
}
public int getbalancebyid(int c)
{
    String sql="select Balance from Wallet where Customer_Id=?";
    return template.queryForObject(sql,new Object[]{c},Integer.class);
}
public int getWalletid(int c)
{
    String sql="select Wallet_id from Wallet where Customer_Id=?";
    return template.queryForObject(sql,new Object[]{c},Integer.class);
}


}  