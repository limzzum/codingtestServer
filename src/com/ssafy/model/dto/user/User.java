package com.ssafy.model.dto.user;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String password;
    private String name;
    private String address;
}
