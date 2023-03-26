package com.ssafy.model.dto.community;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Hotplace {
    private int hotplaceNo;
    private String id;
    private Date date;
    private String subject;
    private String content;
    private String address;
    private int hit;
}
