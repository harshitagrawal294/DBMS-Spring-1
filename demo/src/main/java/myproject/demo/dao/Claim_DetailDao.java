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

import myproject.demo.models.Claim_Detail;
// import myproject.demo.models.Company;
// import myproject.demo.models.Office;
// import myproject.demo.models.Wallet; 

@Transactional
@Repository
public class Claim_DetailDao {
@Autowired
JdbcTemplate template;



  
 
public int save(Claim_Detail p) {
    String sql="insert into Claim_Details(Damage,Status,Date,Policy_Number,Customer_Id) values('"+p.getDamage()+"','"+p.getStatus()+"','"+p.getDate()+"',"+p.getPolicy_Number()+","+p.getCustomer_Id()+")";  
    // System.out.print(sql);
    return template.update(sql);  
}  

public int delete(int c){  
    String sql="delete from Claim_Details where Claim_Id="+c+"";  
    return template.update(sql);  
}  
public int update(Claim_Detail p)
{
    String sql="update Claim_Details set Damage='"+p.getDamage()+"',Status='"+p.getStatus()+"',Date='"+p.getDate()+"',Policy_Number="+p.getPolicy_Number()+",Customer_Id="+p.getCustomer_Id()+" where Claim_Id="+p.getClaim_Id()+"";
    return template.update(sql);
}
public int changestatus(int p)
{
    String sql="update Claim_Details set Status=1-Status where Claim_Id="+p+"";
    return template.update(sql);
}
public int getpolicybyclaim(int id)
{
    return template.queryForObject("select Policy_Number from Claim_Details where Claim_Id=?",new Object[]{id}, Integer.class);
}
public int getcustomerbyclaim(int id)
{
    return template.queryForObject("select Customer_Id from Claim_Details where Claim_Id=?",new Object[]{id}, Integer.class);
}
public List<Claim_Detail> getclaimsbycustomer(int id){  
    return template.query("select * from Claim_Details where Customer_Id=?",new Object[]{id},new RowMapper<Claim_Detail>(){  
        public Claim_Detail mapRow(ResultSet rs, int row) throws SQLException {  
        	Claim_Detail e=new Claim_Detail();  
            e.setClaim_Id(rs.getInt(1));  
            e.setDamage(rs.getString(2));  
            e.setStatus(rs.getInt(3));
            e.setDate(rs.getString(4));
            e.setPolicy_Number(rs.getInt(5));
            e.setCustomer_Id(rs.getInt(6));
            return e;  
        }  
    });  
} 
public List<Claim_Detail> getclaimsbypolicy(int id){  
    return template.query("select * from Claim_Details where Policy_Number=?",new Object[]{id},new RowMapper<Claim_Detail>(){  
        public Claim_Detail mapRow(ResultSet rs, int row) throws SQLException {  
        	Claim_Detail e=new Claim_Detail();  
            e.setClaim_Id(rs.getInt(1));  
            e.setDamage(rs.getString(2));  
            e.setStatus(rs.getInt(3));
            e.setDate(rs.getString(4));
            e.setPolicy_Number(rs.getInt(5));
            e.setCustomer_Id(rs.getInt(6));
            return e;  
        }  
    });  
}

public void editDamage(int claim_id, String damage){
    String query = "update Calim_Details set Damage=? where Claim_Id=?";
    template.update(query, damage, claim_id);
}

public Claim_Detail getClaimById(int claim_id){
    String query = "select * from Claim_Detail where Claim_Id="+claim_id;
    return template.queryForObject(query, new RowMapper<Claim_Detail>() {
        @Override
        public Claim_Detail mapRow(ResultSet rs, int i) throws SQLException {
            Claim_Detail e=new Claim_Detail();
            e.setClaim_Id(rs.getInt("Claim_Id"));
            e.setDamage(rs.getString("Damage"));
            e.setStatus(rs.getInt("Status"));
            e.setDate(rs.getString("Date"));
            e.setPolicy_Number(rs.getInt("Policy_Number"));
            e.setCustomer_Id(rs.getInt("Customer_Id"));
            return e;
        }
    });

}


}  