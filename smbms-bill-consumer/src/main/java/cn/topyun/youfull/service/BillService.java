package cn.topyun.youfull.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@FeignClient(value = "smbms-bill-provider")
public interface BillService {

    /**
     * 分页
     * @param pageNum
     * @return
     */

//    Map<String,Object> findAllBills(@RequestParam(value = "pageNum") Integer pageNum,@RequestParam(value = "provider")  Provider provider);
    @RequestMapping(value = "/bill/billList", method = RequestMethod.GET)
    Map toBillMain(@RequestParam(value = "num") String num);
    /**
     * 按条件分页
     * @param pageNum
     * @param wrapper
     * @returndelBill
     */
    @RequestMapping(value = "/bill/delBill", method = RequestMethod.GET)
    String delBill(@RequestParam(value = "billid") String billid);

   // List<BillEx> findAllBillsBy(Integer pageNum, Wrapper wrapper);

   // int delBillById(Integer id);

   // Bill findBillById(Integer id);
}
