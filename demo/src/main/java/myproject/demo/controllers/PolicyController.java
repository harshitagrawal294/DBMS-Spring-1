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
import myproject.demo.dao.PolicyDao;
import myproject.demo.dao.policythingsDao;
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
import myproject.demo.models.Policy;
import myproject.demo.models.Policy_Things_covered;


@Controller
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    PolicyDao dao;
    @Autowired
    CompanyDao dao2;
    @Autowired
    policythingsDao dao3;
    // add -edit -delete -view all -view by company
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/policyform")  
    public String showform(Model m){  
        List<Company> list=dao2.getCompany();
        m.addAttribute("list", list);
    	m.addAttribute("command", new Policy());
    	return "policyform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Policy cust){  
        dao.savenew(cust);
        // int c=dao.getlastcustomer();
        return "redirect:/policy/viewpolicy";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewpolicy")  
    public String viewoffice(Model m){  
        List<Policy> list=dao.getPolicy();  
        m.addAttribute("list",list);
        return "viewpolicy";  
    }  
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);
        return "redirect:/policy/viewpolicy";  
    }  
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  
    public String edit(@PathVariable int id,Model m){  
        Policy p=new Policy();
        p.setPolicy_id(id);
        List<Company> list=dao2.getCompany();
        m.addAttribute("list", list);
        m.addAttribute("command", p);
        return "policyeditform";  
    }   
    @RequestMapping(value="/update",method = RequestMethod.POST)  
    public String update(@ModelAttribute("cust") Policy cust){
        dao.update(cust);
        return "redirect:/policy/viewpolicy";  
    }
    @RequestMapping(value="/companypolicies")  
    public String companypolicies(Model m){
        List<Company> list=dao2.getCompany();
        m.addAttribute("list", list);
        m.addAttribute("command", new Company());
        return "choosepolicycompany";  
    }  
    @RequestMapping(value="/companypoly",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Company cust,Model m){  
        List<Policy> list=dao.getpolicybycompany(cust.getCompany_Id());
        // int c=dao.getlastcustomer();
        m.addAttribute("list", list);
        return "viewpolicybyid";//will redirect to viewemp request mapping  
    }  
    ////// delete a specific thing covered, ,edit things covered
    @RequestMapping(value="/addthingscovered/{id}",method = RequestMethod.GET)  
    public String addthingscovered(@PathVariable int id,Model m){  
        Policy_Things_covered p=new Policy_Things_covered();
        p.setPolicy_Id(id);
        m.addAttribute("command", p);
        return "addthingscovered";  
    }
    @RequestMapping(value="/addthings",method = RequestMethod.POST)  
    public String save(@ModelAttribute("p") Policy_Things_covered p){ 
        dao3.save(p);  
        return "redirect:/policy/things/"+p.getPolicy_Id();//will redirect to viewemp request mapping  
    }  
    @RequestMapping(value="/things/{id}",method = RequestMethod.GET)  
    public String balance(@PathVariable int id,Model m){  
        List<Policy_Things_covered> list=dao3.getthingsforpolicy(id);
        m.addAttribute("list", list);
        return "showthings";
    }
    @RequestMapping(value="/deletethings/{c}/{id}",method = RequestMethod.GET)  
    public String deletethings(@PathVariable int id,@PathVariable String c,Model m){  
        dao3.delete(id, c);
        return "redirect:/policy/things/"+id;
    }
    @RequestMapping(value="/editthings/{c}/{id}",method = RequestMethod.GET)  
    public String editthings(@PathVariable int id,@PathVariable String c,Model m){  
        dao3.delete(id, c);
        return "redirect:/policy/addthingscovered/"+id;
    }

}  