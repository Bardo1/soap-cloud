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
@AllArgsConstructor
@TableName("r_movie_sentence")
public class RMovieSubtitle implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String sid;
    private String mid;
    private String seq;
    private String note;
    private String fileid;
}
