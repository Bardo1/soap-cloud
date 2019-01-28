package org.wzx.cloud.movie.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wzx.cloud.model.entity.MovieDO;

import java.util.List;

public interface MovieService {

    IPage<MovieDO> listMovie(MovieDO movieDO, Page page);

    int addMovie(MovieDO movieDO);
}
