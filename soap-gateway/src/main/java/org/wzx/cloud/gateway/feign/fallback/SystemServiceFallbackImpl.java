package org.wzx.cloud.gateway.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wzx.cloud.gateway.feign.SystemService;
import org.wzx.cloud.model.vo.R;


@Slf4j
@Service
public class SystemServiceFallbackImpl implements SystemService {

//    private static Logger logger = LoggerFactory.getLogger(SystemServiceFallbackImpl.class);

    @Override
    public R listMenu(String parentid) {
        log.error("调用{}失败,param:{}","listMenu",parentid);
        return R.error("调用listMenu失败,param:"+parentid);
    }
}
