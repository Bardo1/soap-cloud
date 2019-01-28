package org.wzx.cloud.system.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wzx.cloud.system.feign.TaskFeign;

@Slf4j
@Component
public class TaskFeignFallBack implements TaskFeign {

    @Override
    public boolean refreshMovies() {
        //TODO 调用rabbitmq
      log.info("fallback方法,调用rabbitmq,存入refreshMovies");
      return false;
    }
}
