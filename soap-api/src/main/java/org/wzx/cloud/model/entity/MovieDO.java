package org.wzx.cloud.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_movies")
public class MovieDO implements Serializable {

    private Integer id;
    private Integer typeid;
    private Integer parentid;
    private String name;
    private String fullname;
    private String description;
    private String note;
    private String seq;

}
