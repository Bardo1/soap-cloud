package org.wzx.cloud.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wzx.cloud.model.entity.MenuDO;
import org.wzx.cloud.model.vo.R;
import org.wzx.cloud.system.service.MenuService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public R listMenu(@RequestParam("parentid") String parentid) {
        if (StringUtils.isBlank(parentid)) {
            R.error("传入的parentid不能为空");
        }
        try {
            List<MenuDO> list = menuService.listMenu(parentid);
            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }

    }
}
