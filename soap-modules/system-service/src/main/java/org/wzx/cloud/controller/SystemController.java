package org.wzx.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wzx.cloud.model.vo.R;
import org.wzx.cloud.service.SystemService;

@Slf4j
@RestController
@RequestMapping("sysconst")
public class SystemController {

    @Autowired
    private SystemService systemService;

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
