package cn.topyun.youfull.service;

import cn.youfull.entity.Bill;
import cn.youfull.entity.BillEx;
import cn.youfull.entity.Provider;
import cn.youfull.entity.Bill;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;
import java.util.Map;

public interface BillService {

    /**
     * 分页
     * @param pageNum
     * @return
     */
    Map<String,Object> findAllBills(Integer pageNum);

    /**
     * 按条件分页
     * @param pageNum
     * @param wrapper
     * @return
     */
    List<BillEx> findAllBillsBy(Integer pageNum, Wrapper wrapper);

    int delBillById(Integer id);

    Bill findBillById(Integer id);
}
