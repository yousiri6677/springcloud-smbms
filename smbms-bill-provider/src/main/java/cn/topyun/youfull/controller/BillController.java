package cn.topyun.youfull.controller;

import cn.topyun.youfull.service.BillService;
import cn.topyun.youfull.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/bill")
@Controller
public class BillController {

    @Resource
    private BillService billService;

    @Resource
    private ProviderService providerService;

    @RequestMapping("/billList")
    @ResponseBody
    public Map toBillMain(String num) {
        Map<String, Object> allBills = billService.findAllBills(num == null ? 1 : Integer.parseInt(num));
        allBills.put("providers", providerService.findAllProviders());
        return allBills;
    }

    @RequestMapping("/delBill")
    @ResponseBody
    public String delBill(String billid) {
        String data = "notexist";
        if (billService.findBillById(Integer.parseInt(billid)) != null) {
            if (billService.delBillById(Integer.parseInt(billid)) > 0) {
                data = "true";
            } else {
                data = "false";
            }
        }
        System.out.println(data);
        return data;
    }
    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "123";
    }

    @RequestMapping("/findBill/{id}/{isPay}")
    public String findBill(@PathVariable("name") String name, @PathVariable("id") long id, @PathVariable("isPay") Integer isPay) {
        return "";
    }
}