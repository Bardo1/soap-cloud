package org.wzx.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzx.cloud.mapper.ConstMapper;
import org.wzx.cloud.service.SystemService;

import java.util.Map;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private ConstMapper constMapper;

    @Override
    public Map<String, String> listConst() throws Exception {
        return null;
    }

    @Override
    public void saveConst(Map<String, String> map) throws Exception {

    }

    @Override
    public void refreshMovieList() throws Exception {

    }
}
