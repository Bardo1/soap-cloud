package org.wzx.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wzx.cloud.service.SystemTaskService;

@Slf4j
@Service
public class SystemTaskServiceImpl implements SystemTaskService {

    @Override
    public boolean refreshMovieList() {
        //TODO 调用刷新refreshMovieList 异步方法
      log.info("调用刷新refreshMovieList 异步方法");
      return true;
    }
}
