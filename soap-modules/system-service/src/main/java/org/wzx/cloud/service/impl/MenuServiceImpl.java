package org.wzx.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzx.cloud.mapper.MenuMapper;
import org.wzx.cloud.model.entity.MenuDO;
import org.wzx.cloud.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDO> listMenu(String parentid) throws Exception {
        Integer count = menuMapper.selectCount(new QueryWrapper<MenuDO>().eq("menuid", parentid));
        if (count == 0) {
            throw new Exception("传入的menuid错误");
        } else {
            List<MenuDO> list = menuMapper.listMenuByParentid(parentid);
            return list;
        }
    }
}
