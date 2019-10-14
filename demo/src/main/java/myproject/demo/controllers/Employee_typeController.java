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
import myproject.demo.dao.Employee_typeDao;
// import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Document;
import myproject.demo.models.Employee_type;
// add ,delete, know salary, update salary,view employeee

@Controller
@RequestMapping("/employee_type")
public class Employee_typeController {
    @Autowired  
    Employee_typeDao dao;//will inject dao from xml file
    

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/emptypeform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Employee_type());
    	return "emptypeform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Employee_type cust){  
        dao.save(cust);
        return "redirect:/employee_type/viewemptype";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemptype")  
    public String viewemptype(Model m){  
        List<Employee_type> list=dao.getEmployee_type();  
        m.addAttribute("list",list);
        return "viewemptype";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/employee_type/viewemptype";  
    }   
    @RequestMapping(value="/update/{id}",method = RequestMethod.GET)  
    public String Update(@PathVariable int id,Model m){  
        Employee_type p= new Employee_type();
        p.setIdentification(id);        
        m.addAttribute("command", p);
        return "empupdateform";
    }   
    @RequestMapping(value="/update_salary",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Employee_type cust){  
        dao.updatesalary(cust);
        return "redirect:/employee_type/viewemptype";//will redirect to viewemp request mapping  
    }  

}  