package org.wzx.cloud.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_const")
public class ConstDO implements Serializable {

    private String name;
    private String value;

}
