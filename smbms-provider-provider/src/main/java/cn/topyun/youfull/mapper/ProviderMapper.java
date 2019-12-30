package cn.topyun.youfull.mapper;

import cn.youfull.entity.Provider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProviderMapper extends BaseMapper<ProviderMapper> {

    @Select("select *  from smbms_provider where id =#{id}")
    Provider selectProviderById(Integer id);

    @Select("select * From smbms_provider ")
    List<Provider> selectAllProviders();
}
