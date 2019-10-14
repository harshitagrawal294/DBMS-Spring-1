package myproject.demo.controllers;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myproject.demo.dao.CustomerContactsDao;
import myproject.demo.dao.CustomerDao;
import myproject.demo.dao.CustomerEmailDao;
import myproject.demo.dao.DocumentDao;
import myproject.demo.dao.WalletDao;
import myproject.demo.models.Customer;
import myproject.demo.models.Customer_Contact;
import myproject.demo.models.Customer_Email_Id;
import myproject.demo.models.Document;


@Controller
@RequestMapping("/admincustomer")
public class Customer_controller {  
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

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("")  
    public String showform(Model m){  
    	m.addAttribute("command", new Customer());
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
        return "redirect:/customer/viewcustomer";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewcustomer")  
    public String viewcustomer(Model m){  
        List<Customer> list=dao.getCustomer();  
        m.addAttribute("list",list);
        return "viewcustomer";  
    }  
    
    @RequestMapping(value="/deletecustomer/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
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
        dao.delete(id);  
        return "redirect:/customer/viewcustomer";  
    }   

    //for customer contact
    @RequestMapping(value="/showcontact/{id}",method = RequestMethod.GET)  
    public String showcontact(Model m,@PathVariable int id){  
        List<Customer_Contact> list=dao2.getCustomerContacts(id);  
        m.addAttribute("list",list);
        return "showcontact";  
    }  
    @RequestMapping(value="/deletecontact/{id}/{contact}",method = RequestMethod.GET)  
    public String deletecontact(@PathVariable int id,@PathVariable String contact){  
        dao2.delete(id,contact);  
        return "redirect:/customer/showcontact/"+id;  
    }   
    @RequestMapping(value="/addcontact/{id}",method = RequestMethod.GET)  
    public String addcontact(@PathVariable int id,Model m){ 
         Customer_Contact c=new Customer_Contact();
         c.setCustomer_Id(id);
         m.addAttribute("command", c);
         return "addcontactform";
         
    }   
    @RequestMapping(value="/savecontact",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer_Contact cust){ 
        dao2.save(cust);  
        return "redirect:/customer/viewcustomer";//will redirect to viewemp request mapping  
    }  

    // end of customer contact

    // for email id's
    @RequestMapping(value="/showemails/{id}",method = RequestMethod.GET)  
    public String showemails(Model m,@PathVariable int id){  
        List<Customer_Email_Id> list=dao3.getCustomerEmail(id);  
        System.out.println("FUCK");
        System.out.println(list);
        for(Customer_Email_Id PP:list)
        {
            System.out.println(PP.getEmail_Id());
        }
        m.addAttribute("list",list);
        return "showemails";  
    }  
    @RequestMapping(value="/deleteemails/{id}/{emails}",method = RequestMethod.GET)  
    public String deleteemails(@PathVariable int id,@PathVariable String emails){  
        dao3.delete(id,emails);  
        return "redirect:/customer/showemails/"+id;  
    }   
    @RequestMapping(value="/addemails/{id}",method = RequestMethod.GET)  
    public String addemails(@PathVariable int id,Model m){ 
         Customer_Email_Id c=new Customer_Email_Id();
         c.setCustomer_Id(id);
         m.addAttribute("command", c);
         return "addemailform";
         
    }   
    @RequestMapping(value="/saveemails",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer_Email_Id cust){  
        dao3.save(cust);  
        return "redirect:/customer/viewcustomer";//will redirect to viewemp request mapping  
    }  

}  