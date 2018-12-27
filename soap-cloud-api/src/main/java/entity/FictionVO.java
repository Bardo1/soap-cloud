package entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_fiction")
public class FictionVO implements Serializable {

    private int id;
    private String title;
    private String author;
    private String description;
}
