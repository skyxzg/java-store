package com.taobao.yiwei.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class FreshMan extends CollegeStudent {
    private Integer score;
    private String addr;
}
