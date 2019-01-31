package org.wzx.cloud.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class MenuDO implements Serializable {
    private Integer menuid;
    private Integer parentid;
    private String name;
    private String url;
    private String descrition;
    private Integer typeid;
    private Integer seq;
}
