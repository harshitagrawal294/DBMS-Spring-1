package myproject.demo.controllers;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
// import java.util.Map;

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
import myproject.demo.dao.WalletDao;
import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
import myproject.demo.models.Wallet;   


@Controller
@RequestMapping("/wallet")
public class WalletController {
    @Autowired  
    CustomerDao dao;//will inject dao from xml file
    @Autowired
    CustomerContactsDao dao2;
    @Autowired
    CustomerEmailDao dao3;
    @Autowired
    WalletDao dao4;

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/viewbalance")  
    public String showbalance(Model m){  
        List<Customer> list = dao.getCustomer();
        m.addAttribute("list",list);
    	m.addAttribute("command", new Customer());
    	return "walletchooseform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/showbalance",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer cust){  
        int a=cust.getCustomer_Id();
        // return "redirect:/customer/viewcustomer";//will redirect to viewemp request mapping
        
        return "redirect:/wallet/balance/"+a;

    }  
    @RequestMapping(value="/balance/{id}",method = RequestMethod.GET)  
    public String balance(@PathVariable int id,Model m){  
        int a=dao4.getbalancebyid(id);
        // System.out.println(a);
        String name=dao.namebyid(id);
        m.addAttribute("balance", a);
        m.addAttribute("name", name);
        return "balanceshow";  
    }
    @RequestMapping(value="/addbalance/{id}",method = RequestMethod.GET)  
    public String addbalance(@PathVariable int id,Model m){  
        Wallet p=new Wallet();
        p.setCustomer_Id(id);
        m.addAttribute("command", p);
        return "addbalance";  
    }
    @RequestMapping(value="/updatebalance",method = RequestMethod.POST)  
    public String save(@ModelAttribute("p") Wallet p){ 
        dao4.update(p);  
        return "redirect:/wallet/balance/"+p.getCustomer_Id();//will redirect to viewemp request mapping  
    }  

    

}  