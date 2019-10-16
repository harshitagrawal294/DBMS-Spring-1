package myproject.demo.controllers;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import java.security.Principal;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

// import java.util.List;
// import java.util.Map;

import myproject.demo.dao.*;
import myproject.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMethod;

// import myproject.demo.models.Asset;
// import myproject.demo.models.Company;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Customer_Policy;
// import myproject.demo.models.Document;
// import myproject.demo.models.Employee;
// import myproject.demo.models.Employee_type;
// import myproject.demo.models.Office;
// // import myproject.demo.models.User;
// import myproject.demo.models.Wallet;


@Controller
@RequestMapping("/employee")
public class EmployeeUserController {
    @Autowired  
    CustomerDao customerdao;//will inject dao from xml file
    @Autowired
    CustomerContactsDao customerContactsdao;
    @Autowired
    CustomerEmailDao CustomerEmailDao;
    @Autowired
    WalletDao WalletDao;
    @Autowired
    DocumentDao DocumentDao;
    @Autowired
    Userdao Userdao;
    @Autowired 
    Customer_PoliciesDao Customer_PoliciesDao;
    @Autowired
    Claim_DetailDao claimDetailDao;
    @Autowired
    AssetDao assetdao;
    @Autowired
    OfficeDao officedao;
    @Autowired 
    CompanyDao CompanyDao;
    @Autowired
    Employee_typeDao Employee_typeDao;
    @Autowired
    JdbcTemplate template;
    @Autowired
    EmployeeDao EmployeeDao;
    @Autowired
    PolicyDao PolicyDao;
    @Autowired
    FeedbackDao FeedbackDao; 
    @Autowired 
    TransactionDao TransactionDao;
    
    // add customer information,
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    // logout,(add,delete/edit/view company)done,add/delete/edit/view employee+check things to delete when deleting employee,(add/delete/edit/view employeetype)done,(add/delete/edit/view office)done,add/delete/edit/view customer+check things to delete when deleting customer,add/delete/edit/view policies
    @RequestMapping("")  
    public String homepage(Principal principal,Model m){  
        m.addAttribute("Emp", EmployeeDao.getemployeeByusername(principal.getName()));
        return "ehomepage";

    }  
    @RequestMapping("/myinfo")  
    public String myinfo(Principal principal,Model m){  
        m.addAttribute("cust", EmployeeDao.getemployeeByusername(principal.getName()));
        String etype=EmployeeDao.getetype((EmployeeDao.getemployeeByusername(principal.getName())).getUser_Id());
        String office=EmployeeDao.getoffice((EmployeeDao.getemployeeByusername(principal.getName())).getUser_Id());
        m.addAttribute("etype", etype);
        m.addAttribute("office", office);
        return "emyinfo";

    }  
    @RequestMapping("/addbalance")  
    public String addbalance(Model m){  
        List<Customer> list=customerdao.getCustomer();
        m.addAttribute("list", list);
        m.addAttribute("command", new Wallet());
        return "choosecust";

    }  
    @RequestMapping(value="/addbal",method = RequestMethod.POST)  
    public String update(@ModelAttribute("p") Wallet p){ 
        int id=p.getCustomer_Id();
        int nid=WalletDao.getWalletid(id);
        p.setWallet_id(nid);
        WalletDao.update(p);    
        return "redirect:/employee";
        
    }  

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
        return "viewepolicies";
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
        return "viewepolicies";
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
        return "viewepolicies";
        
    }
    @RequestMapping("/viewdocs")
    public String viewdocs(Model m)
    {
        final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Document> list=template.query("select Document_Id,Document_Type,Verification_Status,Link_to_doc,c.Customer_Id as Customer_Id,Name from Documents as d,Customer as c where c.Customer_Id=d.Customer_Id",new ResultSetExtractor<List<Document> >(){  
	        public List<Document> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Document> list = new ArrayList<Document>();  
	            while(rs.next()){  
                    Document bt = new Document();
	               bt.setDocument_Id(rs.getInt("Document_Id"));
	               bt.setDocument_Type(rs.getString("Document_Type"));
	               bt.setVerification_Status(rs.getInt("Verification_Status"));
	               bt.setLink_to_doc(rs.getString("Link_to_doc"));
	               bt.setCustomer_Id(rs.getInt("Customer_Id"));
	           	   map.put(rs.getInt("Customer_Id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });  
        m.addAttribute("list",list);
        m.addAttribute("map", map);
        return "viewdocs";
    }
    @RequestMapping(value="/deletedoc/{a}",method = RequestMethod.GET)  
    public String deletedoc(@PathVariable int a){  
        DocumentDao.deleteDocument(a);
        return "redirect:/employee/viewdocs";
    }
    // delete doc completed
    // edit status
    @RequestMapping(value="/editstatus/{a}",method = RequestMethod.GET)  
    public String editstatus(@PathVariable int a){  
        DocumentDao.editstatus(a);
        return "redirect:/employee/viewdocs";
    }
    @RequestMapping("/adddoc")
    public String adddoc(Model m)
    {
        List<Customer> list=customerdao.getCustomer();
        m.addAttribute("list", list);
        m.addAttribute("command", new Document());
        return "choosedoc";
    }
    @RequestMapping("/docsave")
    public String docsave(@ModelAttribute("doc") Document doc){  
        DocumentDao.save(doc);
        return "redirect:/employee/viewdocs/";
        
    }
    @RequestMapping("/feedback")
    public String feedback(Model m,Principal principal)
    {
        final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Feedback> list=template.query("select Serial_Number,Remarks,e.User_Id as User_Id,Name from Feedback as f,Employee as e where f.User_Id=e.User_Id",new ResultSetExtractor<List<Feedback> >(){  
	        public List<Feedback> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Feedback> list = new ArrayList<Feedback>();  
	            while(rs.next()){  
                    Feedback bt = new Feedback();
	               bt.setSerial_Number(rs.getInt("Serial_Number"));
	               bt.setRemarks(rs.getString("Remarks"));
	               bt.setUser_Id(rs.getInt("User_Id"));
	               map.put(rs.getInt("User_Id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        Employee e=EmployeeDao.getemployeeByusername(principal.getName());
        m.addAttribute("list",list);
        m.addAttribute("map", map);
        m.addAttribute("e", e);
        return "forumpost";
    }
    @RequestMapping("addfeedback")
    public String addfeedback(Principal principal,Model m)
    {
        Feedback p=new Feedback();
        p.setUser_Id((EmployeeDao.getemployeeByusername(principal.getName())).getUser_Id());
        m.addAttribute("command", p);
        return "feedbackform";//will redirect to viewemp request mapping  
    }
    @RequestMapping(value="/savefeedback",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Feedback cust){  
        FeedbackDao.save(cust);
        return "redirect:/employee/feedback";//will redirect to viewemp request mapping  
    }  
    @RequestMapping(value="/deletefeedback/{a}",method = RequestMethod.GET)  
    public String deletefeedback(@PathVariable int a){  
        FeedbackDao.delete(a);
        return "redirect:/employee/feedback";
    }
    // delete doc completed
    // edit status
    @RequestMapping(value="/editfeedback/{id}",method = RequestMethod.GET)  
    public String editfeedback(@PathVariable int id,Model m,Principal principal){  
        Feedback p=new Feedback();
        p.setSerial_Number(id);
        p.setUser_Id((EmployeeDao.getemployeeByusername(principal.getName())).getUser_Id());
        m.addAttribute("command",p);
        // List<Employee> list=dao2.getEmployee();
        // m.addAttribute("list", list);
        return "editfeedback";  
    }  
    @RequestMapping(value="/editfeedbacks",method = RequestMethod.POST)  
    public String editfeedback(@ModelAttribute("cust") Feedback cust){  
        FeedbackDao.update(cust);
        return "redirect:/employee/feedback";//will redirect to viewemp request mapping  
    }
    @RequestMapping("viewtransactions")
    public String viewtransactions(Model m)
    {
        final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Transaction> list=template.query("select money,status,t.Customer_Id,transactionid,Name from transaction as t,Customer as c where t.status=0 and t.Customer_Id=c.Customer_Id",new ResultSetExtractor<List<Transaction> >(){  
	        public List<Transaction> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Transaction> list = new ArrayList<Transaction>();  
	            while(rs.next()){  
                    Transaction bt = new Transaction();
	               bt.setMoney(rs.getFloat("money"));
	               bt.setStatus(rs.getInt("status"));
                   bt.setCustomer_Id(rs.getInt("Customer_Id"));
                   bt.setTransactionid(rs.getInt("transactionid"));
	               map.put(rs.getInt("transactionid"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
       
        m.addAttribute("list",list);
        m.addAttribute("map", map);
        // m.addAttribute("e", e);
        return "pendingtransaction";
    }
    @RequestMapping(value="/changetstatus/{id}",method = RequestMethod.GET)  
    public String changetstatus(@PathVariable int id,Principal principal){
        int eid=(EmployeeDao.getemployeeByusername(principal.getName())).getUser_Id();
        TransactionDao.savebyemployee(id, eid);
        int money=TransactionDao.getmoney(id);
        int cid=TransactionDao.getcustomer(id);
        Wallet w=new Wallet();
        w.setBalance(money);
        w.setCustomer_Id(cid);
        WalletDao.update(w);
        return "redirect:/employee/viewtransactions";
        
    }  
    @RequestMapping("/allclaims")
    public String myclaims(Model m)
    {
        final Map<Integer,String> assetmap=new HashMap<Integer,String>();
        final Map<Integer,String> policymap=new HashMap<Integer,String>();
        final Map<Integer,String> companymap=new HashMap<Integer,String>();
        final Map<Integer,String> customermap=new HashMap<Integer,String>();
    	List<Claim_Detail> list=template.query("select cs.Name as CustomerName,Claim_Id,Damage,Status,Date,c.Policy_Number,c.Customer_Id,cp.Asset_Id,cp.Policy_id,Details,Name_of_Policy,p.Company_Id,cmp.Name as cmpname from Customer as cs, Company as cmp,Policy as p,Customer_Policies as cp,Assets as a,Claim_Details as c where c.Policy_Number=cp.Policy_Number and a.Asset_Id=cp.Asset_Id and p.Policy_id=cp.Policy_id and p.Company_Id=cmp.Company_Id and cs.Customer_Id=c.Customer_Id",new ResultSetExtractor<List<Claim_Detail> >(){  
	        public List<Claim_Detail> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Claim_Detail> list = new ArrayList<Claim_Detail>();  
	            while(rs.next()){  
                    Claim_Detail bt = new Claim_Detail();
	               bt.setClaim_Id(rs.getInt("Claim_Id"));
	               bt.setDamage(rs.getString("Damage"));
	               bt.setStatus(rs.getInt("Status"));
	               bt.setDate(rs.getString("Date"));
                   bt.setPolicy_Number(rs.getInt("Policy_Number"));
                   bt.setCustomer_Id(rs.getInt("Customer_Id"));
                      assetmap.put(rs.getInt("Claim_Id"),rs.getString("Details"));
                      policymap.put(rs.getInt("Claim_Id"),rs.getString("Name_of_Policy"));
                      companymap.put(rs.getInt("Claim_Id"),rs.getString("cmpname"));
                      customermap.put(rs.getInt("Claim_Id"),rs.getString("CustomerName"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
        m.addAttribute("assetmap", assetmap);
        m.addAttribute("policymap", policymap);
        m.addAttribute("companymap", companymap); 
        m.addAttribute("customermap", customermap); 
        m.addAttribute("list", list); 
        return "showallclaims"; 
    }

    /////////////////////////////////////// Claim Section //////////////////////////////////////////////////////////////

    @GetMapping("/claim/add")
    public String addClaim(Model m, Principal p){
        m.addAttribute("customers", customerdao.getAllCustomer());
        m.addAttribute("claim", new Claim_Detail());
        return "addClaim";
    }

    @PostMapping("/claim/add")
    public String addClaim(@ModelAttribute("claim") Claim_Detail c, Principal p){
        claimDetailDao.save(c);
        // System.out.println("OK2");
        return "redirect:/employee/ehomepage";
    }

    @RequestMapping("/claim/{claim_id}/delete")
    public String deleteClaim(@PathVariable int claim_id){
        claimDetailDao.delete(claim_id);
        return "redirect:/employee";
    }

    @RequestMapping("/claim/{claim_id}")
    public String viewClaim(@PathVariable int claim_id, Model m){
        m.addAttribute("claim", claimDetailDao.getClaimById(claim_id));
        return "viewClaim";
    }

    @GetMapping("/claim/{claim_id}/edit")
    public String editClaim(@PathVariable int claim_id, Principal p, Model m){
        m.addAttribute("claim", new Claim_Detail());
        return "editClaim";
    }
    @RequestMapping(value="/editclaimstatus/{id}",method=RequestMethod.GET)
    public String editclaimstatus(@PathVariable int id){
        claimDetailDao.changestatus(id);
        return "redirect:/employee/allclaims";
    }

    @PostMapping("/claim/{claim_id}/edit")
    public String editClaim(@PathVariable int claim_id, @ModelAttribute("claim") Claim_Detail c){
        claimDetailDao.editDamage(claim_id, c.getDamage());
        return "redirect:/employee/ehomepage";
    }


//    @RequestMapping("/api/get/assets")
//    public List<Asset> getApiAssetByCustomerId(@RequestParam(value = "Customer_Id", defaultValue = "1") String Customer_Id){
//        return assetdao.getassetsbycustomer(Integer.parseInt(Customer_Id));
//    }

//    @RequestMapping("/api/get_policy_number")
//    public int getApiPolicyNo(@RequestParam int Customer_Id, @RequestParam int Asset_Id){
//        return Customer_PoliciesDao.getPolicyNumber(Customer_Id, Asset_Id);
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}




