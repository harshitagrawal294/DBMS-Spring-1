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

// import myproject.demo.dao.CompanyDao;
import myproject.demo.dao.CustomerDao;
import myproject.demo.dao.Customer_PoliciesDao;
import myproject.demo.dao.EmployeeDao;
import myproject.demo.dao.PolicyDao;
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
import myproject.demo.models.Employee;
import myproject.demo.models.Policy;


@Controller
@RequestMapping("/customerpolicies")
public class Customer_PolicyController {
    @Autowired
    Customer_PoliciesDao dao;
    @Autowired
    PolicyDao dao2;
    @Autowired
    EmployeeDao dao3;
    @Autowired
    CustomerDao dao4;

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/newpolicyform")  
    public String showform(Model m){  
        m.addAttribute("command", new Customer_Policy());
        List<Policy> list1=dao2.getPolicy();
        List<Employee> list2=dao3.getEmployee();
        List<Customer> list3=dao4.getCustomer();
        m.addAttribute("list1",list1);
        m.addAttribute("list2",list2);
        m.addAttribute("list3",list3);

    	return "newpolicyform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer_Policy cust){  
        dao.save(cust);
        int c=dao.getlast();
        return "redirect:/customerpolicies/viewpolicies/"+c;//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping(value="/viewpolicies/{id}",method = RequestMethod.GET)  
    public String view(@PathVariable int id,Model m){  
        List<Customer_Policy> list=dao.getpolicybycustomer(id);
        m.addAttribute("list", list);
        return "viewcustomerpolicies";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        int a=dao.getcustomerbyid(id);
        dao.delete(id);
        
        return "redirect:/customerpolicies/viewpolicies/"+a;
    }  
      

}  