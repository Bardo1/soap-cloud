package org.wzx.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.wzx.cloud.model.entity.MenuDO;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDO> {

    List<MenuDO> listMenuByParentid(String parentid);
}
