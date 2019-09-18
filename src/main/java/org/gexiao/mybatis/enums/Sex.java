package org.gexiao.mybatis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: gexiao
 * @Date: 2019/9/18 09:54
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum Sex {
    FEMALE(2, "女"),
    MALE(1, "男"),

    ;
    private int id;
    private String name;

    public static Sex get(int id) {
        for (Sex sex : values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        throw new RuntimeException("找不到对应的枚举，传入值===> " + id);
    }
}
