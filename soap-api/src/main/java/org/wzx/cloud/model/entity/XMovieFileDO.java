package org.wzx.cloud.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@TableName("x_movie_list")
public class XMovieFileDO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String name;
    private String url;
    private String type;
    private String parentid;
}
