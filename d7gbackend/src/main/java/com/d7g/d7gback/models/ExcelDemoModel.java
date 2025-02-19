package com.d7g.d7gback.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

import cn.idev.excel.annotation.ExcelProperty;

@Getter
@Setter
@ToString
public class ExcelDemoModel {
    @ExcelProperty("测试内容")
    private String string;
    @ExcelProperty("测试时间")
    private Date date;
    @ExcelProperty("测试分值")
    private Double doubleData;
}
