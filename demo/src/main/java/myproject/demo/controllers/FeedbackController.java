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
import myproject.demo.dao.EmployeeDao;
import myproject.demo.dao.FeedbackDao;
// import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Document;
import myproject.demo.models.Employee;
import myproject.demo.models.Feedback;

// view for particular user


@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackDao dao;
    @Autowired
    EmployeeDao dao2;

      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/feedbackform")  
    public String showform(Model m){  
        m.addAttribute("command", new Employee());
        List<Employee> list=dao2.getEmployee();
        m.addAttribute("list", list);
    	return "empchooseforfeed"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/addfeedback",method = RequestMethod.POST)  
    public String addfeedback(Model m,@ModelAttribute("cust") Employee cust){  
        Feedback p=new Feedback();
        p.setUser_Id(cust.getUser_Id());
        m.addAttribute("command", p);
        return "feedbackform";//will redirect to viewemp request mapping  
    }  
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Feedback cust){  
        dao.save(cust);
        return "redirect:/feedback/viewfeedback";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewfeedback")  
    public String viewfeedback(Model m){  
        List<Feedback> list=dao.getFeedback();  
        m.addAttribute("list",list);
        return "viewfeedback";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/feedback/viewfeedback";  
    }   

    //for customer contact
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  
    public String edit(@PathVariable int id,Model m){  
        Feedback p=new Feedback();
        p.setSerial_Number(id);
        m.addAttribute("command",p);
        List<Employee> list=dao2.getEmployee();
        m.addAttribute("list", list);
        return "editfeedback";  
    }  
    @RequestMapping(value="/editfeedback",method = RequestMethod.POST)  
    public String editfeedback(@ModelAttribute("cust") Feedback cust){  
        dao.update(cust);
        return "redirect:/feedback/viewfeedback";//will redirect to viewemp request mapping  
    }  
    @RequestMapping(value="/viewbyid/{id}",method = RequestMethod.GET)  
    public String viewbyid(@PathVariable int id,Model m){  
        List<Feedback> list= dao.getFeedbackforuser(id);
        m.addAttribute("list", list);
        return "viewbyidfeedback";  
    }  

}  