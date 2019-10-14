package myproject.demo.controllers;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
// import java.util.Map;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myproject.demo.dao.AssetDao;
import myproject.demo.dao.CustomerContactsDao;
import myproject.demo.dao.CustomerDao;
import myproject.demo.dao.CustomerEmailDao;
import myproject.demo.dao.Customer_PoliciesDao;
import myproject.demo.dao.DocumentDao;
import myproject.demo.dao.PolicyDao;
import myproject.demo.dao.Userdao;
import myproject.demo.dao.WalletDao;
import myproject.demo.models.Asset;
import myproject.demo.models.Claim_Detail;
import myproject.demo.models.Customer;
import myproject.demo.models.Customer_Contact;
import myproject.demo.models.Customer_Email_Id;
import myproject.demo.models.Customer_Policy;
import myproject.demo.models.Document;
import myproject.demo.models.Policy;
import myproject.demo.models.User;
import myproject.demo.models.Wallet;


@Controller
@RequestMapping("/customer")
public class CustomerUserController {
    @Autowired  
    CustomerDao dao;//will inject dao from xml file
    @Autowired
    CustomerContactsDao dao2;
    @Autowired
    CustomerEmailDao dao3;
    @Autowired
    WalletDao dao4;
    @Autowired
    DocumentDao dao5;
    @Autowired
    Userdao userdao;
    @Autowired 
    Customer_PoliciesDao dao6;
    @Autowired
    AssetDao assetdao;
    @Autowired
    PolicyDao PolicyDao;
    @Autowired
    JdbcTemplate template;

    // add customer information,
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("")  
    public String showform(Principal principal){  
        // User user=userdao.findByUsername(principal.getName());
        if(dao.userExist(principal.getName()))
            return "redirect:/customer/homepage";
        else
            return "redirect:/customer/customerform";

    	
    }  
    @RequestMapping("/customerform")  
    public String showform(Model m,Principal principal){  
        User user=userdao.findByUsername(principal.getName());
        Customer c=new Customer();
        c.setUsername(user.getUsername());
    	m.addAttribute("command", c);
    	return "customerform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer cust){  
        dao.save(cust);
        int c=dao.getlastcustomer();
        dao4.savenew(c);
        return "redirect:/customer/homepage";//will redirect to viewemp request mapping  
    }  
    @RequestMapping("/homepage")  
    public String homepage(Model m,Principal principal){  
        // User user=userdao.findByUsername(principal.getName());
        m.addAttribute("customer", dao.getCustomerByusername(principal.getName()));
        return "homepageforcustomer";
    }  
    @RequestMapping("/myinfo")  
    public String myinfo(Model m,Principal principal){  
        m.addAttribute("cust", dao.getCustomerByusername(principal.getName()));
        Customer c=dao.getCustomerByusername(principal.getName());
        int id=c.getCustomer_Id();
        int balance=dao4.getbalancebyid(id);
        m.addAttribute("balance", balance);
        return "customerinfo";
    } 
    @RequestMapping("/deletecustomer")  
    public String delete(Model m,Principal principal){  
        Customer c=dao.getCustomerByusername(principal.getName());
        int id=c.getCustomer_Id();
        dao4.delete(id);
        List<Customer_Contact> list=dao2.getCustomerContacts(id);
        for (Customer_Contact var : list) {
            dao2.delete(var.getCustomer_Id(),var.getContact());
            
        }
        List<Customer_Email_Id> list2=dao3.getCustomerEmail(id);
        for (Customer_Email_Id var : list2) {
            dao3.delete(var.getCustomer_Id(),var.getEmail_Id());
            
        }
        List<Document> list3=dao5.getdocbyid(id);
        for (Document var : list3) {
            dao5.deleteDocument(var.getDocument_Id());
            
        }
        List<Customer_Policy> list4=dao6.getpolicybycustomer(id);
        for (Customer_Policy var : list4) {
            dao6.delete(var.getPolicy_Number());
            
        }
        //assets,documents of,claim details.
        dao.delete(id);
        userdao.delete(c.getUsername());
        return "redirect:/";
    }  

      

    @RequestMapping("/showcontact")  
    public String showcontact(Model m,Principal principal){  
        Customer c=dao.getCustomerByusername(principal.getName());
        int id=c.getCustomer_Id();
        List<Customer_Contact> list=dao2.getCustomerContacts(id);  
        m.addAttribute("list",list);
        return "showcontact";  
    } 
    @RequestMapping(value="/deletecontact/{contact}",method = RequestMethod.GET)  
    public String deletecontact(@PathVariable String contact, Principal principle) {
        Customer c=dao.getCustomerByusername(principle.getName());
        int id=c.getCustomer_Id();
        dao2.delete(id,contact);  
        return "redirect:/customer/showcontact/";  
    } 
    @RequestMapping("/addcontact")  
    public String addcontact(Model m,Principal principal){  
        Customer_Contact c=new Customer_Contact();
        Customer c1=dao.getCustomerByusername(principal.getName());
        int id=c1.getCustomer_Id();
         c.setCustomer_Id(id);
         m.addAttribute("command", c);
         return "addcontactform";  
    }  
    @RequestMapping(value="/savecontact",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer_Contact cust){ 
        dao2.save(cust);  
        return "redirect:/customer/showcontact/";//will redirect to viewemp request mapping  
    }   
    //////////////////////////////////////////////
    @RequestMapping("/showemails")  
    public String showemails(Model m,Principal principal){  
        Customer c=dao.getCustomerByusername(principal.getName());
        int id=c.getCustomer_Id();
        List<Customer_Email_Id> list=dao3.getCustomerEmail(id);  
        m.addAttribute("list",list);
        return "showemails";  
    } 
    @RequestMapping(value="/deleteemails/{contact}",method = RequestMethod.GET)  
    public String deleteemails(@PathVariable String contact, Principal principle) {
        Customer c=dao.getCustomerByusername(principle.getName());
        int id=c.getCustomer_Id();
        dao3.delete(id,contact);  
        return "redirect:/customer/showemails/";  
    } 
    @RequestMapping("/addemails")  
    public String addemails(Model m,Principal principal){  
        Customer_Email_Id c=new Customer_Email_Id();
        Customer c1=dao.getCustomerByusername(principal.getName());
        int id=c1.getCustomer_Id();
         c.setCustomer_Id(id);
         m.addAttribute("command", c);
         return "addemailform";  
    }  
    @RequestMapping(value="/saveemails",method = RequestMethod.POST)  
    public String saveemails(@ModelAttribute("cust") Customer_Email_Id cust){ 
        dao3.save(cust);  
        return "redirect:/customer/showemails/";//will redirect to viewemp request mapping  
    } 
    @RequestMapping("/addbalance")  
    public String addbalance(Model m,Principal principal){  
        Wallet p=new Wallet();
        Customer c=dao.getCustomerByusername(principal.getName());
        int id=c.getCustomer_Id();
        p.setCustomer_Id(id);
        m.addAttribute("command", p);
        return "addbalance"; 
    }    
    @RequestMapping(value="/updatebalance",method = RequestMethod.POST)  
    public String save(@ModelAttribute("p") Wallet p){ 
        dao4.update(p);  
        return "redirect:/customer/myinfo/";//will redirect to viewemp request mapping  
    }  
    //////////////////////
    ////view policy///////
    @RequestMapping("/policies/vehicle")  
    public String viewvpolicies(Model m){
        final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Policy> list=template.query("select Policy_id,Name_of_Policy,Cost_per_month,things_to_cover,type,p.Company_Id,Name from Policy as p,Company as c where type='vehicle' and c.Company_Id=p.Company_Id",new ResultSetExtractor<List<Policy> >(){  
	        public List<Policy> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Policy> list = new ArrayList<Policy>();  
	            while(rs.next()){  
                    Policy bt = new Policy();
	               bt.setPolicy_id(rs.getInt("Policy_id"));
	               bt.setName_of_Policy(rs.getString("Name_of_Policy"));
	               bt.setCost_per_month(rs.getInt("Cost_per_month"));
	               bt.setThingscover(rs.getString("things_to_cover"));
                   bt.setType(rs.getString("type"));
                   bt.setCompany_Id(rs.getInt("Company_Id"));
	           	   map.put(rs.getInt("Company_Id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("map", map);
        m.addAttribute("list", list);
        m.addAttribute("t", "vehicle");
        return "viewvpolicies";
    }
    @RequestMapping("/policies/property")  
    public String viewppolicies(Model m){
        final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Policy> list=template.query("select Policy_id,Name_of_Policy,Cost_per_month,things_to_cover,type,p.Company_Id,Name from Policy as p,Company as c where type='property' and c.Company_Id=p.Company_Id",new ResultSetExtractor<List<Policy> >(){  
	        public List<Policy> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Policy> list = new ArrayList<Policy>();  
	            while(rs.next()){  
                    Policy bt = new Policy();
	               bt.setPolicy_id(rs.getInt("Policy_id"));
	               bt.setName_of_Policy(rs.getString("Name_of_Policy"));
	               bt.setCost_per_month(rs.getInt("Cost_per_month"));
	               bt.setThingscover(rs.getString("things_to_cover"));
                   bt.setType(rs.getString("type"));
                   bt.setCompany_Id(rs.getInt("Company_Id"));
	           	   map.put(rs.getInt("Company_Id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("map", map);
        m.addAttribute("list", list);
        m.addAttribute("t", "property");
        return "viewvpolicies";
    }
    @RequestMapping("/policies/health")  
    public String viewhpolicies(Model m){
        final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Policy> list=template.query("select Policy_id,Name_of_Policy,Cost_per_month,things_to_cover,type,p.Company_Id,Name from Policy as p,Company as c where type='health' and c.Company_Id=p.Company_Id",new ResultSetExtractor<List<Policy> >(){  
	        public List<Policy> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Policy> list = new ArrayList<Policy>();  
	            while(rs.next()){  
                    Policy bt = new Policy();
	               bt.setPolicy_id(rs.getInt("Policy_id"));
	               bt.setName_of_Policy(rs.getString("Name_of_Policy"));
	               bt.setCost_per_month(rs.getInt("Cost_per_month"));
	               bt.setThingscover(rs.getString("things_to_cover"));
                   bt.setType(rs.getString("type"));
                   bt.setCompany_Id(rs.getInt("Company_Id"));
	           	   map.put(rs.getInt("Company_Id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("map", map);
        m.addAttribute("list", list);
        m.addAttribute("t", "health");
        return "viewvpolicies";
        
    }
    //////////////////////
    //mypolicies//////////
    // @RequestMapping("/myassets")  
    // public String myassets(Model m,Principal principal){  
    //     int id=(dao.getCustomerByusername(principal.getName())).getCustomer_Id();
    //     List<Map<String,Object>> rows=JdbcTemplate.queryForList("select p.");
    //     m.addAttribute("rows", rows);
    //     return "viewemployee"; 
     
    // }  




    ///////////////////////
    ///assets/////////////

    @RequestMapping("/myassets")  
    public String myassets(Model m,Principal principal){  
        // Customer_Contact c=new Customer_Contact();
        Customer c1=dao.getCustomerByusername(principal.getName());
        int id=c1.getCustomer_Id();
        List<Asset> list=assetdao.getassetsbycustomer(id);
        // m.addAttribute("command", c);
        m.addAttribute("list", list);
        return "myassets";  
    }  
    ///////////////////////////////
    ///my claims///////////////////
    @RequestMapping("/myclaims")
    public String myclaims(Principal principal,Model m)
    {
        final Map<Integer,String> assetmap=new HashMap<Integer,String>();
        final Map<Integer,String> policymap=new HashMap<Integer,String>();
        final Map<Integer,String> companymap=new HashMap<Integer,String>();
        int id=(dao.getCustomerByusername(principal.getName())).getCustomer_Id();
    	List<Claim_Detail> list=template.query("select Claim_Id,Damage,Status,Date,c.Policy_Number,c.Customer_Id,cp.Asset_Id,cp.Policy_id,Details,Name_of_Policy,p.Company_Id,cmp.Name as cmpname from Company as cmp,Policy as p,Customer_Policies as cp,Assets as a,Claim_Details as c where c.Customer_Id="+id+" and c.Policy_Number=cp.Policy_Number and a.Asset_Id=cp.Asset_Id and p.Policy_id=cp.Policy_id and p.Company_Id=cmp.Company_Id",new ResultSetExtractor<List<Claim_Detail> >(){  
	        public List<Claim_Detail> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Claim_Detail> list = new ArrayList<Claim_Detail>();  
	            while(rs.next()){  
                    Claim_Detail bt = new Claim_Detail();
	               bt.setClaim_Id(rs.getInt("Claim_Id"));
	               bt.setDamage(rs.getString("Damage"));
	               bt.setStatus(rs.getString("Status"));
	               bt.setDate(rs.getString("Date"));
                   bt.setPolicy_Number(rs.getInt("Policy_Number"));
                   bt.setCustomer_Id(rs.getInt("Customer_Id"));
                      assetmap.put(rs.getInt("Claim_Id"),rs.getString("Details"));
                      policymap.put(rs.getInt("Claim_Id"),rs.getString("Name_of_Policy"));
                      companymap.put(rs.getInt("Claim_Id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("assetmap", assetmap);
        m.addAttribute("policymap", policymap);
        m.addAttribute("companymap", companymap); 
        m.addAttribute("list", list); 
        return "showmyclaims"; 
    }

}  