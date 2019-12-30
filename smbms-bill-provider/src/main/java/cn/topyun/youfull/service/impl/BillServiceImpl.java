package cn.topyun.youfull.service.impl;

import cn.topyun.youfull.mapper.BillMapper;
import cn.youfull.entity.Bill;
import cn.youfull.entity.BillEx;
import cn.youfull.entity.Provider;
import cn.topyun.youfull.service.BillService;
import cn.topyun.youfull.service.ProviderService;
import cn.youfull.util.TimeFormat;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper billMapper;

    @Resource
    private ProviderService providerService;

    @Value("${pagesize}")
    private String pageSize;

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Map<String,Object> findAllBills(Integer pageNum) {
        List<BillEx> bills = new ArrayList<BillEx>();
        Map<String, Object> billMaps = new HashMap<>();
        BillEx billEx = null;
        IPage<Bill> ipage=new Page<Bill>(pageNum,Integer.parseInt(pageSize));
        for (Bill bill : billMapper.selectPage(ipage,null).getRecords() ) {
            billEx = new BillEx();
            BeanUtils.copyProperties(bill, billEx);
            billEx.setCreationDateStr(TimeFormat.TIME_FORMAT.getFormat().format(bill.getCreationDate()));
            billEx.setProvider(providerService.findProviderById(bill.getProviderId()));
            bills.add(billEx);
        }
        billMaps.put("bills", bills);
        billMaps.put("pageTotal", ipage.getTotal());
        billMaps.put("pageCurrent", ipage.getCurrent());
        billMaps.put("pageNum", ipage.getPages());
        return billMaps;
    }

    @Override
    public List<BillEx> findAllBillsBy(Integer pageNum, Wrapper wrapper) {
        return null;
    }

    @Override
    public int delBillById(Integer id) {
        return  billMapper.deleteById(id);
    }

    @Override
    public Bill findBillById(Integer id) {
        return billMapper.selectById(id);
    }
}
