package org.wzx.cloud.movie.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzx.cloud.model.vo.SubtitleVO;
import org.wzx.cloud.movie.mapper.SubtitleMapper;
import org.wzx.cloud.movie.service.SubtitleService;

@Service
public class SubtitleServiceImpl implements SubtitleService {

    @Autowired
    private SubtitleMapper subtitleMapper;

    @Override
    public IPage<SubtitleVO> listSubtitleVO(Page page,String movieid) {
        IPage<SubtitleVO> iPage = subtitleMapper.listSubtitleVO(page,movieid);
        return iPage;
    }
}
