package com.ssafy.model.dto.community;

import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Tip {
    private int tipNo;
    private String id;
    private Date date;
    private String subject;
    private String content;
    private int hit;
}
