package org.wzx.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzx.cloud.feign.TaskFeign;
import org.wzx.cloud.mapper.ConstMapper;
import org.wzx.cloud.model.entity.ConstDO;
import org.wzx.cloud.service.SystemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private ConstMapper constMapper;

    @Autowired
    private TaskFeign taskFeign;

    @Override
    public Map<String, String> listConst() throws Exception {
        List<ConstDO> list = constMapper.selectList(new QueryWrapper<ConstDO>());
        Map<String, String> sysconst = new HashMap<>();
        for (ConstDO constDO : list) {
            sysconst.put(constDO.getName(), constDO.getValue());
        }
        return sysconst;
    }

    @Override
    public void saveConst(Map<String, String> map) throws Exception {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ConstDO constDO = new ConstDO();
            constDO.setName(entry.getKey());
            constDO.setValue(entry.getValue().replaceAll("，",","));
            constMapper.update(constDO, new QueryWrapper<ConstDO>().eq("name", entry.getKey()));
        }
    }

    @Override
    public boolean refreshMovieList() throws Exception {
        return taskFeign.refreshMovies();
    }
}
