package fu.meter.app.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @author meter
 * @version V1.0
 * Copyright ©2020
 * @ClassName Demo
 * @desc 测试实例
 * @date 2020/12/24 11:51
 */
@Data
public class Demo implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String flag="0";
}
