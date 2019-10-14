package myproject.demo.controllers;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myproject.demo.dao.Claim_DetailDao;
// import myproject.demo.dao.CompanyDao;
import myproject.demo.dao.CustomerDao;
import myproject.demo.dao.Customer_PoliciesDao;
import myproject.demo.dao.EmployeeDao;
import myproject.demo.dao.PolicyDao;
import myproject.demo.models.Claim_Detail;
// import myproject.demo.dao.CustomerContactsDao;
// import myproject.demo.dao.CustomerDao;
// import myproject.demo.dao.CustomerEmailDao;
// import myproject.demo.dao.DocumentDao;
// import myproject.demo.dao.OfficeDao;
// import myproject.demo.models.Company;
import myproject.demo.models.Customer;
// import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Document;
// import myproject.demo.models.Office;
import myproject.demo.models.Customer_Policy;
// import myproject.demo.models.Employee;
// import myproject.demo.models.Policy;


@Controller
@RequestMapping("/claimdetails")
public class ClaimDetailController {
    @Autowired
    Claim_DetailDao dao;
    @Autowired
    Customer_PoliciesDao dao1;
    @Autowired
    PolicyDao dao2;
    @Autowired
    EmployeeDao dao3;
    @Autowired
    CustomerDao dao4;
    // add new claim,view all claim for customer, view all claim confirmed,pending for customer,view all claims underparticular customerpolicy,delete
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping(value="/claimform")  
    public String showform1(Model m){  
        m.addAttribute("command", new Customer());
        List<Customer> list=dao4.getCustomer();
        m.addAttribute("list", list);
    	return "newclaimform1"; 
    }  
    @RequestMapping(value="/newclaimform",method = RequestMethod.POST)  
    public String showform(Model m,@ModelAttribute("cust") Customer cust){  
        // m.addAttribute("command", new Customer_Policy());
        List<Customer_Policy> list1=dao1.getpolicybycustomer(cust.getCustomer_Id());
        Claim_Detail p=new Claim_Detail();
        p.setCustomer_Id(cust.getCustomer_Id());
        m.addAttribute("command", p);
        // List<Customer> list2=dao4.getCustomer();
        m.addAttribute("list1",list1);
        // m.addAttribute("list2",list2);
        // m.addAttribute("list3",list3);

    	return "newclaimform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Claim_Detail cust){  
        dao.save(cust);
        int c=cust.getPolicy_Number();
        // int c=dao.getlast();
        return "redirect:/claimdetails/viewclaims/"+c;//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping(value="/viewclaims/{id}",method = RequestMethod.GET)  
    public String view(@PathVariable int id,Model m){  
        List<Claim_Detail> list=dao.getclaimsbypolicy(id);
        m.addAttribute("list", list);
        return "viewclaimpolicies";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        int a=dao.getpolicybyclaim(id);
        dao.delete(id);
        
        return "redirect:/customerpolicies/viewpolicies/"+a;
    }
    @RequestMapping(value="/update/{id}",method = RequestMethod.GET)  
    public String update(@PathVariable int id,Model m){  
        Claim_Detail p=new Claim_Detail();
        p.setClaim_Id(id);
        p.setPolicy_Number(dao.getpolicybyclaim(id));
        p.setCustomer_Id(dao.getcustomerbyclaim(id));
        // List<Customer_Policy> list1=dao1.getpolicybycustomer(dao.getcustomerbyclaim(id));
        m.addAttribute("command", p);
        
        return "updateclaim";
    }  

    @RequestMapping(value="/upd",method = RequestMethod.POST)  
    public String upd(@ModelAttribute("cust") Claim_Detail cust){  
        dao.update(cust);
        int c=cust.getPolicy_Number();
        // int c=dao.getlast();
        return "redirect:/claimdetails/viewclaims/"+c;//will redirect to viewemp request mapping  
    } 

}  