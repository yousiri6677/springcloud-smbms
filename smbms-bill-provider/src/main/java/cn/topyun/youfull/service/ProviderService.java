package cn.topyun.youfull.service;


import cn.youfull.entity.Provider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "smbms-provider-provider")
public interface ProviderService {

    @RequestMapping(value = "/provider/findProviderById", method = RequestMethod.GET)
    Provider findProviderById(@RequestParam(value = "id")Integer id);

    @RequestMapping(value = "/provider/findAllProviders", method = RequestMethod.GET)
    List<Provider> findAllProviders();

}
