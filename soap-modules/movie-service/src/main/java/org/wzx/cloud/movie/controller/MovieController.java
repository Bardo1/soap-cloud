package org.wzx.cloud.movie.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wzx.cloud.model.entity.MovieDO;
import org.wzx.cloud.model.vo.R;
import org.wzx.cloud.movie.service.MovieService;
import org.wzx.cloud.util.Consts;

@RequestMapping
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/list")
    public R listMovie(MovieDO query, @RequestParam(defaultValue = "1",value = "current",required = false) int current, @RequestParam(value = "pages",defaultValue = "10",required = false) int pagesize) {
        if (query.getTypeid() == null) {
            return R.error("请选择查询的种类");
        } else if (query.getTypeid() == Consts.MOVIE_EPISODES && query.getId() == null && query.getParentid() == null) {
            return R.error("请输入至少一个查询条件");
        }
        try {
            IPage<MovieDO> iPage = movieService.listMovie(query, new Page(current, pagesize));
            return R.ok(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }

    }

    @PutMapping
    public R addMovie(MovieDO movie) {
        if (StringUtils.isBlank(movie.getName())) {
            return R.error("名字必填项");
        }
        int count = 0;
        try {
            count = movieService.addMovie(movie);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
        return R.ok("成功添加" + count + "条数据");
    }
//
//    @GetMapping("/player/list")
//    public R listMoviePlayerList() throws Exception {
//        TreeNode list = movieService.listMoviePlayer();
//        return R.ok(list);
//    }

}
