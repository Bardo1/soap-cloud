package org.wzx.cloud.movie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzx.cloud.model.entity.MovieDO;
import org.wzx.cloud.movie.mapper.MovieMapper;
import org.wzx.cloud.movie.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public IPage<MovieDO> listMovie(MovieDO movieDO, Page page) {
        QueryWrapper wrapper = new QueryWrapper<MovieDO>();
        if (movieDO.getId()!=null){
            wrapper.eq("id",movieDO.getId());
        }
        if (movieDO.getTypeid()!=null){
            wrapper.eq("typeid",movieDO.getTypeid());
        }
        if (movieDO.getParentid()!=null){
            wrapper.eq("parentid",movieDO.getParentid());
        }
        if (movieDO.getName()!=null&& StringUtils.isNotBlank(movieDO.getName())){
            wrapper.like("name",movieDO.getName());
        }
        if (movieDO.getFullname()!=null&& StringUtils.isNotBlank(movieDO.getFullname())){
            wrapper.like("fullname",movieDO.getFullname());
        }
        if (movieDO.getDescription()!=null&& StringUtils.isNotBlank(movieDO.getDescription())){
            wrapper.like("description",movieDO.getDescription());
        }
        if (movieDO.getNote()!=null&& StringUtils.isNotBlank(movieDO.getNote())){
            wrapper.like("note",movieDO.getNote());
        }
        if (movieDO.getSeq()!=null&& StringUtils.isNotBlank(movieDO.getSeq())){
            wrapper.like("seq",movieDO.getSeq());
        }
        IPage iPage = movieMapper.selectPage(page, wrapper);
        return iPage;
    }

    @Override
    public int addMovie(MovieDO movieDO) {
        int i = movieMapper.insert(movieDO);
        return i;
    }
}
