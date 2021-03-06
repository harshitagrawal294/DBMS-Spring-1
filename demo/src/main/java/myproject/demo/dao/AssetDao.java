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

import myproject.demo.models.Asset;
// import myproject.demo.models.Claim_Detail;
// import myproject.demo.models.Company;
// import myproject.demo.models.Office;
// import myproject.demo.models.Wallet; 
@Transactional
@Repository
public class AssetDao {
@Autowired 
JdbcTemplate template;  



  
 
public int save(Asset p) {
    String sql="insert into Assets(details,Customer_Id,type) values(?,?,?)";
    return template.update(sql, p.getDetails(),p.getCustomerid(),p.getType());
}  

public int delete(int c){  
    String sql="delete from Assets where Asset_Id="+c;
    return template.update(sql);  
}  


public List<Asset> getassetsbypolicy(int id){  
    return template.query("select * from Assets where Policy_Number=?",new Object[]{id},new RowMapper<Asset>(){  
        public Asset mapRow(ResultSet rs, int row) throws SQLException {  
        	Asset e=new Asset();  
            e.setAssetid(rs.getInt(1));  
            // e.setPolicynumber(rs.getInt(2));  
            e.setCustomerid(rs.getInt(3));
            e.setDetails(rs.getString(2));
            e.setType(rs.getString(4));
            return e;  
        }  
    });  
} 


public List<Asset> getassetsbycustomer(int id){  
    return template.query("select * from Assets where Customer_Id=?",new Object[]{id},new RowMapper<Asset>(){  
        public Asset mapRow(ResultSet rs, int row) throws SQLException {  
        	Asset e=new Asset();  
            e.setAssetid(rs.getInt(1));  
            // e.setPolicynumber(rs.getInt(2));  
            e.setCustomerid(rs.getInt(3));
            e.setDetails(rs.getString(2));
            e.setType(rs.getString(4));
            return e;  
        }  
    });  
} 

public List<Asset> getSecuredAssetByCustomer(int c_id){
    String query = "select * from Assets as a where a.Asset_Id in " +
            "( select Asset_Id from Customer_Policies where date_of_expire >= CURDATE() and Customer_Id=?)";
    return template.query(query, new Object[]{c_id}, new RowMapper<Asset>() {
        @Override
        public Asset mapRow(ResultSet rs, int i) throws SQLException {
            Asset e=new Asset();
            e.setAssetid(rs.getInt(1));
            e.setDetails(rs.getString(2));
            e.setCustomerid(rs.getInt(3));
            e.setType(rs.getString(4));
            return e;
        }
    });
}

public List<Asset> getUnsecuredAssetByCustomer(int c_id){
    String query = "select * from Assets where Asset_ID NOT IN  (select Asset_Id from Customer_Policies where date_of_expire>curdate() and Customer_Id=?) and Customer_Id=?";
    return template.query(query, new Object[]{c_id,c_id}, new RowMapper<Asset>() {
        @Override
        public Asset mapRow(ResultSet rs, int i) throws SQLException {
            Asset e=new Asset();
            e.setAssetid(rs.getInt(1));
            e.setDetails(rs.getString(2));
            e.setCustomerid(rs.getInt(3));
            e.setType(rs.getString(4));
            return e;
        }
    });
}

public String getTypeById(int asset_id){
    String query = "select type from Assets where Asset_Id="+asset_id;
    return template.queryForObject(query, String.class);
}

}  