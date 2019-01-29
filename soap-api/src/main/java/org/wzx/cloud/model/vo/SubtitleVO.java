package org.wzx.cloud.model.vo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubtitleVO {
    private Integer id;
    private String sentence;
    private String typeid;
    private String translation;
    private Integer beginTime;
    private Integer endTime;
    private String rid;
    private Integer seq;
    private Integer movieid;
    private String note;
}
