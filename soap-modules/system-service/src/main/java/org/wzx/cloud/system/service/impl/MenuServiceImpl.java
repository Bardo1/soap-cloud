package org.wzx.cloud.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.wzx.cloud.system.mapper.MenuMapper;
import org.wzx.cloud.system.service.MenuService;
import org.wzx.cloud.model.entity.MenuDO;
import org.wzx.cloud.util.Consts;

import java.awt.*;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Cacheable("listmenu")
    public List<MenuDO> listMenu(String url) throws Exception {
        Integer count = menuMapper.selectCount(new QueryWrapper<MenuDO>().eq("url", url).eq("typeid", Consts.MENU_LEVEL1));
        if (count != 1) {
            throw new Exception("不存在该url,请检查前台路由");
        } else {
            MenuDO menuDO = menuMapper.selectOne(new QueryWrapper<MenuDO>().eq("url", url).eq("typeid", Consts.MENU_LEVEL1));
            List<MenuDO> list = menuMapper.selectList(new QueryWrapper<MenuDO>().eq("parentid",menuDO.getMenuid()).eq("typeid",Consts.MENU_LEVEL2));
            return list;
        }
    }
}
