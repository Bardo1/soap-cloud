package org.wzx.cloud.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wzx.cloud.model.vo.R;
import org.wzx.cloud.system.service.SystemService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("sysconst")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping
    public R list() throws Exception {
        Map<String, String> sysconst = systemService.listConst();
        return R.ok(sysconst);
    }

    @PostMapping("/save")
    public R saveSysConstt(@RequestParam Map<String, String> map) {
        try {
            systemService.saveConst(map);
            systemService.refreshMovieList();
            return R.ok("保存成功");
        } catch (Exception e) {
            return R.error("保存失败");
        }
    }

    @GetMapping("/refreshMovies")
    public R refreshMovieList() throws Exception {
        try {
            boolean flag = systemService.refreshMovieList();
            return R.ok("刷新成功:"+flag);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }
}
