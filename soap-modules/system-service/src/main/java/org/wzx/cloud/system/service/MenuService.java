package org.wzx.cloud.system.service;

import org.wzx.cloud.model.entity.MenuDO;

import java.util.List;

public interface MenuService {

    List<MenuDO> listMenu(String parentid) throws Exception;
}
