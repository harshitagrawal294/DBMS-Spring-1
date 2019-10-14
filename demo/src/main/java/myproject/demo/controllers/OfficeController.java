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

// import myproject.demo.dao.CustomerContactsDao;
// import myproject.demo.dao.CustomerDao;
// import myproject.demo.dao.CustomerEmailDao;
// import myproject.demo.dao.DocumentDao;
import myproject.demo.dao.OfficeDao;
// import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Document;
import myproject.demo.models.Office;


@Controller
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    OfficeDao dao;

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/officeform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Office());
    	return "officeform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Office cust){  
        dao.savenew(cust);
        // int c=dao.getlastcustomer();
        return "redirect:/office/viewoffice";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewoffice")  
    public String viewoffice(Model m){  
        List<Office> list=dao.getOffice();  
        m.addAttribute("list",list);
        return "viewoffice";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);
        return "redirect:/office/viewoffice";  
    }  
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  
    public String edit(@PathVariable int id,Model m){  
        Office p=new Office();
        p.setOffice_Id(id);
        m.addAttribute("command", p);
        return "officeeditform";  
    }   
    @RequestMapping(value="/update",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Office cust){
        dao.update(cust);
        return "redirect:/office/viewoffice";  
    }   

}  