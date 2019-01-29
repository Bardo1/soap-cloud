package org.wzx.cloud.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.wzx.cloud.model.entity.SubtitleDO;
import org.wzx.cloud.model.vo.SubtitleVO;

@Mapper
public interface SubtitleMapper extends BaseMapper<SubtitleDO> {

    IPage<SubtitleVO> listSubtitleVO(Page page,String movieid);
}
