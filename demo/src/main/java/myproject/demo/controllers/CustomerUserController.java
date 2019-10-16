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
import org.springframework.web.bind.annotation.*;

import myproject.demo.dao.AssetDao;
import myproject.demo.dao.CustomerContactsDao;
import myproject.demo.dao.CustomerDao;
import myproject.demo.dao.CustomerEmailDao;
import myproject.demo.dao.Customer_PoliciesDao;
import myproject.demo.dao.DocumentDao;
import myproject.demo.dao.DocumentofDao;
import myproject.demo.dao.PolicyDao;
import myproject.demo.dao.TransactionDao;
import myproject.demo.dao.Userdao;
import myproject.demo.dao.WalletDao;
import myproject.demo.models.Asset;
import myproject.demo.models.Claim_Detail;
import myproject.demo.models.Customer;
import myproject.demo.models.Customer_Contact;
import myproject.demo.models.Customer_Email_Id;
import myproject.demo.models.Customer_Policy;
import myproject.demo.models.Document;
import myproject.demo.models.Documentof;
import myproject.demo.models.Policy;
import myproject.demo.models.Transaction;
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
    Customer_PoliciesDao cPolicyDao;
    @Autowired
    AssetDao assetdao;
    @Autowired
    PolicyDao PolicyDao;
    @Autowired
    JdbcTemplate template;
    @Autowired
    DocumentofDao DocumentofDao;
    @Autowired
    TransactionDao TransactionDao;
    @Autowired
    WalletDao WalletDao;

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
        List<Customer_Policy> list4=cPolicyDao.getpolicybycustomer(id);
        for (Customer_Policy var : list4) {
            cPolicyDao.delete(var.getPolicy_Number());
            
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
        return "redirect:/customer/showcontact";  
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
        return "redirect:/customer/showcontact";//will redirect to viewemp request mapping  
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
        return "redirect:/customer/showemails";  
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
        return "redirect:/customer/showemails";//will redirect to viewemp request mapping  
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
        Transaction t=new Transaction();
        t.setCustomer_Id(p.getCustomer_Id());
        t.setMoney(p.getBalance());
        t.setStatus(0);
        TransactionDao.savebycustomer(t);
        return "redirect:/customer/myinfo";//will redirect to viewemp request mapping  
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
    @RequestMapping("mypolicies")
    public String mypolicies(Model m,Principal principal)
    {
        final Map<Integer,String> assetmap=new HashMap<Integer,String>();
        final Map<Integer,String> policymap=new HashMap<Integer,String>();
        final Map<Integer,String> companymap=new HashMap<Integer,String>();
        int id=(dao.getCustomerByusername(principal.getName())).getCustomer_Id();
    	List<Customer_Policy> list=template.query("select Policy_Number,Date_of_Purchase,date_of_expire,cp.Policy_id,cp.Customer_Id,cp.Asset_Id,Details,p.Name_of_Policy,p.Company_Id,cmp.Name as cmpname from Customer_Policies as cp,Assets as a,Policy as p,Company as cmp where cp.Customer_Id="+id+" and cp.Asset_Id=a.Asset_Id and cp.Policy_id=p.Policy_id and p.Company_Id= cmp.Company_Id and date_of_expire>=curdate()",new ResultSetExtractor<List<Customer_Policy> >(){  
	        public List<Customer_Policy> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Customer_Policy> list = new ArrayList<Customer_Policy>();  
	            while(rs.next()){  
                    Customer_Policy bt = new Customer_Policy();
	               bt.setPolicy_Number(rs.getInt("Policy_Number"));
	               bt.setDate_of_Purchase(rs.getString("Date_of_Purchase"));
	               bt.setDateOfExpire(rs.getString("date_of_expire"));
	               bt.setPolicy_Id(rs.getInt("Policy_id"));
                   bt.setAsset_Id(rs.getInt("Asset_Id"));
                   bt.setCustomer_Id(rs.getInt("Customer_Id"));
                      assetmap.put(rs.getInt("Policy_Number"),rs.getString("Details"));
                      policymap.put(rs.getInt("Policy_Number"),rs.getString("Name_of_Policy"));
                      companymap.put(rs.getInt("Policy_Number"),rs.getString("cmpname"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("assetmap", assetmap);
        m.addAttribute("policymap", policymap);
        m.addAttribute("companymap", companymap); 
        m.addAttribute("list", list); 
        return "showmypolicies"; 
    }
    @RequestMapping(value="/linkdocs/{pid}",method = RequestMethod.GET)
    public String linkdocs(Principal principal,@PathVariable int pid,Model m)
    {
        int id=(dao.getCustomerByusername(principal.getName())).getCustomer_Id();
        Documentof d=new Documentof();
        d.setCustomerid(id);
        d.setPolicynumber(pid);
        List<Document> list=template.query("select Document_Id,Document_Type,Verification_Status,Link_to_doc,Customer_Id from Documents as d where d.Customer_Id="+id+" and Verification_Status=1 and (d.Document_Id,"+pid+") not in(select Document_Id,Policy_Number from Documentof)",new ResultSetExtractor<List<Document> >(){  
	        public List<Document> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Document> list = new ArrayList<Document>();  
	            while(rs.next()){  
                    Document bt = new Document();
	               bt.setDocument_Id(rs.getInt("Document_Id"));
	               bt.setDocument_Type(rs.getString("Document_Type"));
	               bt.setVerification_Status(rs.getInt("Verification_Status"));
	               bt.setLink_to_doc(rs.getString("Link_to_doc"));
                   bt.setCustomer_Id(rs.getInt("Customer_Id"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("list", list);
        m.addAttribute("command", d);
        return "choosedocforpolicy";
    }
    @RequestMapping(value="/linkdocsave",method = RequestMethod.POST)  
    public String linkdocsave(@ModelAttribute("p") Documentof p){ 
        DocumentofDao.save(p);  
        return "redirect:/customer/mypolicies";//will redirect to viewemp request mapping  
    }

    ////////////////////////////////////////// Asset Section ///////////////////////////////////////////////////////////

    @RequestMapping("/assets")
    public String myAssets(Model m, Principal p){
        Customer c= dao.getCustomerByusername(p.getName());
        m.addAttribute("secured_assets", assetdao.getSecuredAssetByCustomer(c.getCustomer_Id()));
        m.addAttribute("unsecured_assets", assetdao.getUnsecuredAssetByCustomer(c.getCustomer_Id()));
        return "myAssets";
    }

    @GetMapping("/asset/add")
    public String addAsset(Model m, Principal p){
        m.addAttribute("command", new Asset());
        return "addAsset";
    }

    @PostMapping("/asset/add")
    public String addAsset(@ModelAttribute("asset") Asset a, Principal p){
        a.setCustomerid(dao.getCustomerByusername(p.getName()).getCustomer_Id());
        // System.out.println("Customer_Id="+a.getCustomerid());
        // System.out.println("Type="+a.getType());
        assetdao.save(a);

        return "redirect:/customer/assets";
    }

    @RequestMapping("/asset/{asset_id}/delete")
    public String deleteAsset(@PathVariable int asset_id, Principal p){
        assetdao.delete(asset_id);
        return "redirect:/customer/assets";
    }

    @RequestMapping("/asset/{asset_id}/policy/discontinue")
    public String policyDiscontinue(Model m, Principal p, @PathVariable int asset_id){
        cPolicyDao.discontinueByAssetId(asset_id);
        return "redirect:/customer/assets";
    }

    @GetMapping("/asset/{asset_id}/policy/buy")
    public String buyPolicy(Model m, Principal p, @PathVariable int asset_id,@RequestParam(name="error", defaultValue = "false", required = false) String error){
        Customer_Policy c=new Customer_Policy();
        c.setAsset_Id(asset_id);
        m.addAttribute("command", c);
        int p1=0;
        System.out.println(error);
        if("true".equals(error)){
            System.out.println("OK");
            p1=1;
        }
        m.addAttribute("p1", p1);
        m.addAttribute("policies", PolicyDao.getpolicybytype(assetdao.getTypeById(asset_id)));
        return "buyPolicy";
    }

    @PostMapping("/asset/policy/buy")
    public String buyPolicy(@ModelAttribute("customer_policy") Customer_Policy cp, Principal p){
        cp.setCustomer_Id((dao.getCustomerByusername(p.getName())).getCustomer_Id());
        int money=WalletDao.getbalancebyid((dao.getCustomerByusername(p.getName())).getCustomer_Id());
        int id=cp.getPolicy_Id();
        int cost=PolicyDao.getbalancebyid(id);
        if(cost>money){
            return "redirect:/customer/asset/"+cp.getAsset_Id()+"/policy/buy?error=true";
        }
        WalletDao.decreasebalance((dao.getCustomerByusername(p.getName())).getCustomer_Id(), cost);
        cPolicyDao.save(cp);
        return "redirect:/customer/assets";
    }

    ////////////////////////////////////////// ///////////// ///////////////////////////////////////////////////////////
}