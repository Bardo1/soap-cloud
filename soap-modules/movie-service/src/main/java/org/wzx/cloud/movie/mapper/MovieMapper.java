package org.wzx.cloud.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.wzx.cloud.model.entity.MovieDO;

@Mapper
public interface MovieMapper extends BaseMapper<MovieDO> {
}
