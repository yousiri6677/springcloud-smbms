package cn.topyun.youfull.controller;

import cn.topyun.youfull.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class BillController {

    @Autowired
    private BillService billService;


    @RequestMapping("/toMain")
  //  @ResponseBody
    public String toMain(String num, Model model){
       model.addAttribute("maps",billService.toBillMain(num));
       return "billList";
    }

    @RequestMapping("/del")
    @ResponseBody
    public String delBill(String billid) {
        return  billService.delBill(billid);
    }
}
