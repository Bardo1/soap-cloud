package org.wzx.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wzx.cloud.feign.fallback.TaskFeignFallBack;

@FeignClient(name = "task-service",fallback = TaskFeignFallBack.class)
public interface TaskFeign {

    @RequestMapping("/sysconst/refreshMovies")
    boolean refreshMovies();
}
