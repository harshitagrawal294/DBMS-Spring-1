package myproject.demo.controllers;

import myproject.demo.dao.AssetDao;
import myproject.demo.dao.Customer_PoliciesDao;
import myproject.demo.models.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeApiController {
    @Autowired
    AssetDao assetdao;

    @Autowired
    Customer_PoliciesDao cdao;

    @RequestMapping("/api/get/assets")
    public List<Asset> getApiAssetByCustomerId(@RequestParam int Customer_Id){
        return assetdao.getSecuredAssetByCustomer(Customer_Id);
    }

    @RequestMapping("/api/get_policy_number")
    public int getApiPolicyNo(@RequestParam int Customer_Id, @RequestParam int Asset_Id){
        System.out.println("OK");
        return cdao.getPolicyNumber(Customer_Id, Asset_Id);
    }
}
