package cn.topyun.youfull.service;


import cn.youfull.entity.Provider;

import java.util.List;


public interface ProviderService {

    Provider findProviderById(Integer id);

    List<Provider> findAllProviders();
}
