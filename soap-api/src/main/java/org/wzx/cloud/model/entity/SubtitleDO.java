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
@TableName("sys_sentence")
public class SubtitleDO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String sentence;
    private String typeid;
    private String translation;
    private Integer beginTime;
    private Integer endTime;


}
