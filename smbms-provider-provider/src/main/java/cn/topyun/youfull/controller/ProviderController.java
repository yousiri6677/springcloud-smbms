package cn.topyun.youfull.controller;

import cn.topyun.youfull.service.ProviderService;
import cn.youfull.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @RequestMapping("/findProviderById")
    @ResponseBody
    public Provider findProviderById(Integer id) {
    return providerService.findProviderById(id);
    }

    @RequestMapping("/findAllProviders")
    @ResponseBody
    public List<Provider> findAllProviders() {
        return providerService.findAllProviders();
    }


}
