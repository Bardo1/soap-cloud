package org.wzx.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "task-service")
public interface TaskFeign {

    @RequestMapping("/sysconst/refreshMovies")
    boolean refreshMovies();
}
