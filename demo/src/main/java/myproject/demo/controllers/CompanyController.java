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

import myproject.demo.dao.CompanyDao;
// import myproject.demo.dao.CustomerContactsDao;
// import myproject.demo.dao.CustomerDao;
// import myproject.demo.dao.CustomerEmailDao;
// import myproject.demo.dao.DocumentDao;
// import myproject.demo.dao.OfficeDao;
import myproject.demo.models.Company;
// import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Document;
// import myproject.demo.models.Office;


@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyDao dao;

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/companyform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Company());
    	return "companyform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Company cust){  
        dao.savenew(cust);
        // int c=dao.getlastcustomer();
        return "redirect:/company/viewcompany";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewcompany")  
    public String viewoffice(Model m){  
        List<Company> list=dao.getCompany();  
        m.addAttribute("list",list);
        return "viewcompany";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);
        return "redirect:/company/viewcompany";  
    }  
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  
    public String edit(@PathVariable int id,Model m){  
        Company p=new Company();
        p.setCompany_Id(id);
        m.addAttribute("command", p);
        return "companyeditform";  
    }   
    @RequestMapping(value="/update",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Company cust){
        dao.update(cust);
        return "redirect:/company/viewcompany";  
    }   

}  