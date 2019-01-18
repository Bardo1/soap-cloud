package org.wzx.cloud.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_chapter")

public class ChapterDO implements Serializable {

    private int id;
    private int parentid;
    private String title;
    private String context;

}
