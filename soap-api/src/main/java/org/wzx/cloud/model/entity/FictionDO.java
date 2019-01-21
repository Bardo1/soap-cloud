package org.wzx.cloud.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@TableName("sys_fiction")
public class FictionDO implements Serializable {

    private int id;
    private String title;
    private String author;
    private String description;
}
