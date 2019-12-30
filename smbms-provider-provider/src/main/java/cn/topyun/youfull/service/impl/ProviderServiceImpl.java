package cn.topyun.youfull.service.impl;

import cn.topyun.youfull.mapper.ProviderMapper;
import cn.youfull.entity.Provider;
import cn.topyun.youfull.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private ProviderMapper providerMapper;

    @Override
    public Provider findProviderById(Integer id) {
        return providerMapper.selectProviderById(id);
    }

    @Override
    public List<Provider> findAllProviders() {
        return providerMapper.selectAllProviders();
    }
}
