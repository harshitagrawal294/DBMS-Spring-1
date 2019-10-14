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
// import myproject.demo.models.Customer_Contact;
// import myproject.demo.models.Customer_Email_Id;
import myproject.demo.models.Document;   


@Controller
@RequestMapping("/document")
public class DocumentController {
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
    //add document by id
    //change verification status of docs
    //delete docs
    //show docs for particular id
    // foreign constraint
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    // show a  docs dfor id 
    @RequestMapping("/showdoc")  
    public String showbalance(Model m){  
        List<Customer> list = dao.getCustomer();
        m.addAttribute("list",list);
    	m.addAttribute("command", new Customer());
    	return "docchooseform"; 
    }  
    @RequestMapping(value="/showdocs",method = RequestMethod.POST)  
    public String showdocs(@ModelAttribute("cust") Customer cust){  
        int a=cust.getCustomer_Id();
        // return "redirect:/customer/viewcustomer";//will redirect to viewemp request mapping
        
        return "redirect:/document/show/"+a;
    }  
    @RequestMapping(value="/show/{a}",method = RequestMethod.GET)  
    public String save(Model m,@PathVariable int a){  
        List<Document> list=dao5.getdocbyid(a);
        m.addAttribute("list", list);
        
        return "docforid";
    }  




    // showing all doc by id completed

    // delete doc
    @RequestMapping(value="/deletedoc/{a}",method = RequestMethod.GET)  
    public String deletedoc(@PathVariable int a){  
        dao5.deleteDocument(a);
        return "redirect:/document/show/"+a;
    }
    // delete doc completed
    // edit status
    @RequestMapping(value="/editstatus/{a}",method = RequestMethod.GET)  
    public String editstatus(@PathVariable int a){  
        dao5.editstatus(a);
        a=dao5.getcbyd(a);
        return "redirect:/document/show/"+a;
    }
    // edit status completed

    //add new docs
    @RequestMapping("/addnew")  
    public String addnew(Model m){  
        List<Customer> list = dao.getCustomer();
        m.addAttribute("list",list);
    	m.addAttribute("command", new Customer());
    	return "adddocchooseform"; 
    }  

    @RequestMapping(value="/adddocs",method = RequestMethod.POST)  
    public String adddocs(@ModelAttribute("cust") Customer cust){  
        return "redirect:/document/add/"+cust.getCustomer_Id();
        
    }  
    @RequestMapping(value="/add/{a}",method = RequestMethod.GET)  
    public String savedoc(Model m,@PathVariable int a){  
        Document p=new Document();
        p.setCustomer_Id(a);
        m.addAttribute("command", p);
        
        return "savedocform";
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("doc") Document doc){  
        dao5.save(doc);
        return "redirect:/document/show/"+doc.getCustomer_Id();
        
    }

    //add new docs completed

    

}  