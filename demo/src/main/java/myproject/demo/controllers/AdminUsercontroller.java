package myproject.demo.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

// import java.security.Principal;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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
import myproject.demo.dao.CompanyDao;
import myproject.demo.dao.CustomerContactsDao;
import myproject.demo.dao.CustomerDao;
import myproject.demo.dao.CustomerEmailDao;
import myproject.demo.dao.Customer_PoliciesDao;
import myproject.demo.dao.DocumentDao;
import myproject.demo.dao.EmployeeDao;
import myproject.demo.dao.Employee_typeDao;
import myproject.demo.dao.FeedbackDao;
import myproject.demo.dao.OfficeDao;
import myproject.demo.dao.PolicyDao;
import myproject.demo.dao.Userdao;
import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Asset;
import myproject.demo.models.Company;
import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Customer_Policy;
// import myproject.demo.models.Document;
import myproject.demo.models.Employee;
import myproject.demo.models.Employee_type;
import myproject.demo.models.Feedback;
import myproject.demo.models.Office;
import myproject.demo.models.Policy;
import myproject.demo.models.Transaction;
// import myproject.demo.models.User;
// import myproject.demo.models.Wallet;
import myproject.demo.models.User;


@Controller
@RequestMapping("/admin")
public class AdminUsercontroller {
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
    FeedbackDao FeedbackDao;
    @Autowired
    PolicyDao PolicyDao;
    // add customer information,
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    // logout,(add,delete/edit/view company)done,add/delete/edit/view employee+check things to delete when deleting employee,(add/delete/edit/view employeetype)done,(add/delete/edit/view office)done,add/delete/edit/view customer+check things to delete when deleting customer,add/delete/edit/view policies
    @RequestMapping("")  
    public String homepage(){  
        return "index";
    }  
    //office/////////
    @RequestMapping("/officeform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Office());
    	return "officeform"; 
    }  
    @RequestMapping(value="/officesave",method = RequestMethod.POST)  
    public String officesave(@ModelAttribute("cust") Office cust){  
        officedao.savenew(cust);
        // int c=dao.getlastcustomer();
        return "redirect:/admin/viewoffice";//will redirect to viewemp request mapping  
    }  
    @RequestMapping("/viewoffice")  
    public String viewoffice(Model m){  
        List<Office> list=officedao.getOffice();  
        m.addAttribute("list",list);
        return "viewoffice";  
    }  
    @RequestMapping(value="/deleteoffice/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        officedao.delete(id);
        return "redirect:/admin/viewoffice";  
    }  
    @RequestMapping(value="/editoffice/{id}",method = RequestMethod.GET)  
    public String edit(@PathVariable int id,Model m){  
        Office p=new Office();
        p.setOffice_Id(id);
        m.addAttribute("command", p);
        return "officeeditform";  
    }   
    @RequestMapping(value="/updateoffice",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Office cust){
        officedao.update(cust);
        return "redirect:/admin/viewoffice";  
    }  
    //////////////////////////////////////////////////
    //company/////////////////////////////////////////
    @RequestMapping("/companyform")  
    public String showcform(Model m){  
    	m.addAttribute("command", new Company());
    	return "companyform"; 
    }
    @RequestMapping(value="/companysave",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Company cust){  
        CompanyDao.savenew(cust);
        // int c=dao.getlastcustomer();
        return "redirect:/admin/viewcompany";//will redirect to viewemp request mapping  
    }  
    @RequestMapping("/viewcompany")  
    public String viewcompany(Model m){  
        List<Company> list=CompanyDao.getCompany();  
        m.addAttribute("list",list);
        return "viewcompany";  
    }  
    @RequestMapping(value="/deletecompany/{id}",method = RequestMethod.GET)  
    public String deletecompany(@PathVariable int id){  
        CompanyDao.delete(id);
        return "redirect:/admin/viewcompany";  
    }  
    @RequestMapping(value="/editcompany/{id}",method = RequestMethod.GET)  
    public String editcompany(@PathVariable int id,Model m){  
        Company p=new Company();
        p.setCompany_Id(id);
        m.addAttribute("command", p);
        return "companyeditform";  
    }   
    @RequestMapping(value="/updatecompany",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Company cust){
        CompanyDao.update(cust);
        return "redirect:/admin/viewcompany";  
    }   
    //////////////////////////////////////////////
    //employee type///////////////////////////////
    @RequestMapping("/emptypeform")  
    public String showeform(Model m){  
    	m.addAttribute("command", new Employee_type());
    	return "emptypeform"; 
    }  
    @RequestMapping(value="/emptypesave",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Employee_type cust){  
        Employee_typeDao.save(cust);
        return "redirect:/admin/viewemptype";//will redirect to viewemp request mapping  
    }  
    @RequestMapping("/viewemptype")  
    public String viewemptype(Model m){  
        List<Employee_type> list=Employee_typeDao.getEmployee_type();  
        m.addAttribute("list",list);
        return "viewemptype";  
    }  
    @RequestMapping(value="/deleteemptype/{id}",method = RequestMethod.GET)  
    public String deleteemptype(@PathVariable int id){  
        
        Employee_typeDao.delete(id);  
        // Userdao.delete(username);
        return "redirect:/admin/viewemptype";  
    }   
    @RequestMapping(value="/updateemptype/{id}",method = RequestMethod.GET)  
    public String Update(@PathVariable int id,Model m){  
        Employee_type p= new Employee_type();
        p.setIdentification(id);        
        m.addAttribute("command", p);
        return "empupdateform";
    }   
    @RequestMapping(value="/update_salary",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Employee_type cust){  
        Employee_typeDao.updatesalary(cust);
        return "redirect:/admin/viewemptype";//will redirect to viewemp request mapping  
    }  
    ///////////////////////////////////
    //employee/////////////////////////
    @RequestMapping(value="/addemployee")  
    public String addemployee(Model m){  
        List<User> list= Userdao.getCustomer();
        m.addAttribute("list", list);
        m.addAttribute("command", new User());
        return "custtoemp";//will redirect to viewemp request mapping  
    } 
    @RequestMapping(value="/convertemployee",method = RequestMethod.POST)  
    public String convertemployee(@ModelAttribute("cust") User cust,Model m){  
        String username=cust.getUsername();
        System.out.println(username);
        
        // String username=cust.getUsername();
        boolean p=customerdao.userExist(username);
        if(p){
            Customer c=(customerdao.getCustomerByusername(username));
         int id=c.getCustomer_Id();   
        customerdao.delete(id); 
    }
        Userdao.changetoemp(username);

        Employee e=new Employee();
        e.setUsername(username);
        List<Employee_type> list1=Employee_typeDao.getEmployee_type();
        List<Office> list2=officedao.getOffice();
        m.addAttribute("list1", list1);
        m.addAttribute("list2", list2);
        m.addAttribute("command", e);
        return "employeeform";
        
    } 
    @RequestMapping(value="/esave",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Employee cust){  
        EmployeeDao.save(cust);
        return "redirect:/admin/viewemployee";//will redirect to viewemp request mapping  
    }  
    @RequestMapping("/viewemployee")  
    public String viewemployee(Model m){  
        // List<Employee> list=dao.getEmployee();  
        // m.addAttribute("list",list);
        List<Map<String,Object>> rows=template.queryForList("select e.Name,e.User_Id,e.Date_of_joining,e.Street,e.Contact_Information,e.Gender,e.Pincode,e.Country,e.Identification,e.Office_Id,et.Type as emptype,o.Office_name as oname from Employee_type as et,Office as o,Employee as e where e.Office_Id=o.Office_Id and e.Identification=et.Identification");
        m.addAttribute("rows", rows);
        return "viewemployee";  
    } 
    @RequestMapping(value="/deleteemployee/{id}",method = RequestMethod.GET)  
    public String deleteemployee(@PathVariable int id){  
        String username=(EmployeeDao.getEmployeeById(id)).getUsername();
        EmployeeDao.delete(id);  
        Userdao.delete(username);
        return "redirect:/admin/viewemployee";  
    }   
    @RequestMapping(value="/editemployee/{id}",method = RequestMethod.GET)  
    public String editemployee(@PathVariable int id,Model m){  
        
        Employee p=new Employee();
        p.setUser_Id(id);
        String username=(EmployeeDao.getEmployeeById(id)).getUsername();
        p.setUsername(username);
        m.addAttribute("command", p);
        List<Employee_type> list1=Employee_typeDao.getEmployee_type();
        List<Office> list2=officedao.getOffice();
        m.addAttribute("list1", list1);
        m.addAttribute("list2", list2);
        return "empeditform";

    }   
    
    @RequestMapping(value="/editform",method = RequestMethod.POST)  
    public String editemp(@ModelAttribute("cust") Employee cust){  

        EmployeeDao.update(cust);
        return "redirect:/admin/viewemployee";//will redirect to viewemp request mapping  
    }  

    ////////////////////////////////////////
    ////customer////////////////////////////
    @RequestMapping("/viewcustomer")
    public String viewcostumer(Model m)
    {
        List<Customer> list=customerdao.getCustomer();
        m.addAttribute("list", list);
        return "viewcustomer";  
    }
    @RequestMapping(value="/deletecustomer/{id}",method=RequestMethod.GET)  
    public String delete(Model m,@PathVariable int id){ 
    String username=(customerdao.getCustomerById(id)).getUsername();
    customerdao.delete(id); 
    Userdao.delete(username);
        return "redirect:/admin";
    }
    @RequestMapping("/feedback")
    public String feedback(Model m)
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
        // Employee e=EmployeeDao.getemployeeByusername(principal.getName());
        m.addAttribute("list",list);
        m.addAttribute("map", map);
        // m.addAttribute("e", e);
        return "forums";
    }
    @RequestMapping(value="/deletefeedback/{a}",method = RequestMethod.GET)  
    public String deletefeedback(@PathVariable int a){  
        FeedbackDao.delete(a);
        return "redirect:/admin/feedback";
    }
    @RequestMapping("/policyform")  
    public String showpolicyform(Model m){  
        List<Company> list=CompanyDao.getCompany();
        m.addAttribute("list", list);
    	m.addAttribute("command", new Policy());
    	return "policyform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/policysave",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Policy cust){  
        PolicyDao.savenew(cust);
        // int c=dao.getlastcustomer();
        return "redirect:/admin/viewpolicy";//will redirect to viewemp request mapping  
    } 
    @RequestMapping("/viewpolicy")  
    public String viewpolicy(Model m){  
        List<Policy> list=PolicyDao.getPolicy();  
        m.addAttribute("list",list);
        return "viewpolicy";  
    }   
    @RequestMapping(value="/deletepolicy/{id}",method = RequestMethod.GET)  
    public String deletepolicy(@PathVariable int id){  
        
        PolicyDao.delete(id);
        return "redirect:/admin/viewpolicy";  
    }
    @RequestMapping(value="/editpolicy/{id}",method = RequestMethod.GET)  
    public String editpolicy(@PathVariable int id,Model m){  
        Policy p=new Policy();
        p.setPolicy_id(id);
        p.setCompany_Id(PolicyDao.getCompanybyid(id));
        m.addAttribute("command", p);
        return "policyeditform";  
    }   
    @RequestMapping(value="/updatepolicy",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Policy cust){
        PolicyDao.update(cust);
        return "redirect:/admin/viewpolicy";  
    }
    @RequestMapping(value="/companypolicies")  
    public String companypolicies(Model m){
        List<Company> list=CompanyDao.getCompany();
        m.addAttribute("list", list);
        m.addAttribute("command", new Company());
        return "choosepolicycompany";  
    }  
    @RequestMapping(value="/companypoly",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Company cust,Model m){  
        List<Policy> list=PolicyDao.getpolicybycompany(cust.getCompany_Id());
        // int c=dao.getlastcustomer();
        m.addAttribute("list", list);
        return "viewpolicybyid";//will redirect to viewemp request mapping  
    }  
    @RequestMapping("/showtransactions/pending")
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
        return "allpendingtransaction";
    }
    @RequestMapping("/showtransactions/complete")
    public String allcompletetransactions(Model m)
    {
        final Map<Integer,String> map=new HashMap<Integer,String>();
        final Map<Integer,String> emap=new HashMap<Integer,String>();
    	List<Transaction> list=template.query("select money,status,t.Customer_Id,transactionid,c.Name,e.Name as eName,t.User_Id from Employee as e,transaction as t,Customer as c where t.status=1 and t.Customer_Id=c.Customer_Id and e.User_Id=t.User_Id",new ResultSetExtractor<List<Transaction> >(){  
	        public List<Transaction> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Transaction> list = new ArrayList<Transaction>();  
	            while(rs.next()){  
                    Transaction bt = new Transaction();
	               bt.setMoney(rs.getFloat("money"));
	               bt.setStatus(rs.getInt("status"));
                   bt.setCustomer_Id(rs.getInt("Customer_Id"));
                   bt.setTransactionid(rs.getInt("transactionid"));
                   bt.setUser_Id(rs.getInt("User_Id"));
                   map.put(rs.getInt("transactionid"),rs.getString("Name"));
                   emap.put(rs.getInt("transactionid"),rs.getString("eName"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
        });  
       
        m.addAttribute("list",list);
        m.addAttribute("map", map);
        m.addAttribute("emap", emap);
        // m.addAttribute("e", e);
        return "allcompletetransactions";
    }

}  