package org.wzx.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.wzx.cloud.mapper.ConstMapper;
import org.wzx.cloud.mapper.XMovieListMapper;
import org.wzx.cloud.model.entity.ConstDO;
import org.wzx.cloud.model.entity.XMovieFileDO;
import org.wzx.cloud.service.SystemTaskService;

import java.io.File;

@Slf4j
@Service
public class SystemTaskServiceImpl implements SystemTaskService {

    @Autowired
    private ConstMapper mapper;

    @Autowired
    private XMovieListMapper xmapper;

    @Override
    public boolean refreshMovieList() {
        //TODO 调用刷新refreshMovieList 异步方法
      log.info("调用刷新refreshMovieList 异步方法");
      refreshMovieListAsync();
      return true;
    }

    @Async
    public void refreshMovieListAsync() {
        try {
            ConstDO constDO = mapper.selectOne(new QueryWrapper<ConstDO>().eq("name", "movieDir"));
            String movieDir = constDO.getValue();
            constDO = mapper.selectOne(new QueryWrapper<ConstDO>().eq("name", "nginxDir"));
            String nginxPrefix = constDO.getValue();
            if (!nginxPrefix.endsWith("/")) {
                nginxPrefix = nginxPrefix + "/";
            }
            File root = new File(movieDir);
            if (!root.exists()) {
                throw new Exception("电影目录错误");
            }
            XMovieFileDO xfile = XMovieFileDO.builder().name("/").url("/").type("dir").build();
            xmapper.delete(new QueryWrapper<XMovieFileDO>());
            xmapper.insert(xfile);
            addSubMovieList(root, xfile, movieDir, nginxPrefix);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO 传递错误
        }
    }

    private void addSubMovieList(File parentfile, XMovieFileDO parentdo, String movieDir, String nginxPrefix) throws Exception{
        File[] files = parentfile.listFiles();
        String movieSuffix = queryConstByKey("movieSuffix");
        boolean isAll = false;
        if("*".equals(movieSuffix)){
            isAll = true;
        }
        String[] split = movieSuffix.split(",");
        for (File file : files) {
            String filepath = file.getAbsolutePath();//绝对路径
            String path = filepath.replace(movieDir, "");
            while (path.startsWith("\\")) {
                path = path.substring(1, path.length());
            }
            path = path.replaceAll("\\\\", "/");//相对路径
            if (file.isDirectory()) {
                XMovieFileDO xfile = XMovieFileDO.builder().name(file.getName()).type("dir").url(nginxPrefix + path)
                        .parentid(parentdo.getId()).build();
                xmapper.insert(xfile);
                addSubMovieList(file, xfile, movieDir, nginxPrefix);
            } else {
                XMovieFileDO xfile = new XMovieFileDO();
                String name = file.getName();
                String type = name.substring(name.lastIndexOf(".") + 1, name.length());
                if(!isAll&&!isArraysExist(split,type)){
                    continue;
                }
                xfile.setName(name);
                xfile.setType(type);
                xfile.setUrl(nginxPrefix + path);
                xfile.setParentid(parentdo.getId());
                xmapper.insert(xfile);
            }
        }
    }

    @Cacheable("constKey")
    public String queryConstByKey(String key) throws Exception{
        ConstDO constDO = mapper.selectOne(new QueryWrapper<ConstDO>().eq("name",key));
        if(constDO!=null){
            return constDO.getValue();
        }else {
            throw new Exception("不存在该系统属性");
        }
    }

    private boolean isArraysExist(String[] strs,String str){
        for (String s:strs){
            if(str.equals(s)){
                return true;
            }
        }
        return false;
    }
}
