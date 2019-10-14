package myproject.demo.controllers;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import myproject.demo.dao.Employee_typeDao;
import myproject.demo.dao.OfficeDao;
// import myproject.demo.dao.WalletDao;
// import myproject.demo.models.Customer;
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
// import myproject.demo.models.Document;
import myproject.demo.models.Employee;
import myproject.demo.models.Employee_type;
import myproject.demo.models.Office;


@Controller
@RequestMapping("/adminemployee")
public class EmployeeController {
    @Autowired  
    EmployeeDao dao;
    @Autowired
    OfficeDao dao2;
    @Autowired
    Employee_typeDao dao3;
    @Autowired
    JdbcTemplate JdbcTemplate;

    
    
    
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/employeeform")  
    public String showform(Model m){ 
        List<Employee_type> list1=dao3.getEmployee_type();
        List<Office> list2=dao2.getOffice();
        m.addAttribute("list1", list1);
        m.addAttribute("list2", list2);
    	m.addAttribute("command", new Employee());
    	return "employeeform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Employee cust){  
        dao.save(cust);
        return "redirect:/employee/viewemployee";//will redirect to viewemp request mapping  
    }  
    // /* It provides list of employees in model object */  
    @RequestMapping("/viewemployee")  
    public String viewemployee(Model m){  
        // List<Employee> list=dao.getEmployee();  
        // m.addAttribute("list",list);
        List<Map<String,Object>> rows=JdbcTemplate.queryForList("select e.Name,e.User_Id,e.Date_of_joining,e.Street,e.Contact_Information,e.Gender,e.Pincode,e.Country,e.Identification,e.Office_Id,et.Type as emptype,o.Office_name as oname from Employee_type as et,Office as o,Employee as e where e.Office_Id=o.Office_Id and e.Identification=et.Identification");
        m.addAttribute("rows", rows);
        return "viewemployee";  
    }  
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        
        dao.delete(id);  
        return "redirect:/employee/viewemployee";  
    }   
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  
    public String edit(@PathVariable int id,Model m){  
        
        Employee p=new Employee();
        p.setUser_Id(id);
        m.addAttribute("command", p);
        List<Employee_type> list1=dao3.getEmployee_type();
        List<Office> list2=dao2.getOffice();
        m.addAttribute("list1", list1);
        m.addAttribute("list2", list2);
        return "empeditform";

    }   
    
    @RequestMapping(value="/editform",method = RequestMethod.POST)  
    public String editemp(@ModelAttribute("cust") Employee cust){  
        dao.update(cust);
        return "redirect:/employee/viewemployee";//will redirect to viewemp request mapping  
    }  


    

}  