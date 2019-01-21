package org.wzx.cloud.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.wzx.cloud.feign.TaskFeign;

@Slf4j
//@Component
public class TaskFeignFallBack implements TaskFeign {

    @Override
    public boolean refreshMovies() {
      log.info("fallback方法,调用rabbitmq,存入refreshMovies");
      return false;
    }
}
