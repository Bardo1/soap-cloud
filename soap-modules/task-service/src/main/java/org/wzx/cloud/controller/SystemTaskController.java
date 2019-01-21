package org.wzx.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wzx.cloud.service.SystemTaskService;

@Slf4j
@RestController
@RequestMapping("sysconst")
public class SystemTaskController {

    @Autowired
    private SystemTaskService systemTaskService;

    @GetMapping("/refreshMovies")
    public boolean refreshMovieList(){
        return systemTaskService.refreshMovieList();
    }

}
