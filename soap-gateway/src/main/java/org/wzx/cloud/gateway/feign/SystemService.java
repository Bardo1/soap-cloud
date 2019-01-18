package org.wzx.cloud.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wzx.cloud.gateway.feign.fallback.SystemServiceFallbackImpl;
import org.wzx.cloud.model.vo.R;

@FeignClient(name = "system-service",fallback = SystemServiceFallbackImpl.class)
public interface SystemService {

    @GetMapping("/system/list")
    R listMenu(@RequestParam("parentid") String parentid);
}
