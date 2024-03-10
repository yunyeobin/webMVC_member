package com.ssg.webmvc_member.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String mmail;
    private LocalDate joinDate;


}
