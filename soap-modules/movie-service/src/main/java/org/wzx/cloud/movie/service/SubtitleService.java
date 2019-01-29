package org.wzx.cloud.movie.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wzx.cloud.model.vo.SubtitleVO;

public interface SubtitleService {

    IPage<SubtitleVO> listSubtitleVO(Page page,String movieid);
}
