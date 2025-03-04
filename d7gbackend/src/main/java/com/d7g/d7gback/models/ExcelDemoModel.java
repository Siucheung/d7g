package com.d7g.d7gback.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import cn.idev.excel.annotation.ExcelProperty;

@Getter
@Setter
@ToString
public class ExcelDemoModel {
    @ExcelProperty("参数释义")
    private String parameterDescription;
    @ExcelProperty("参数名")
    private String parameterName;
    @ExcelProperty("参数类型")
    private String parameterType;
    @ExcelProperty("参数是否必填")
    private Boolean required;
    @ExcelProperty("参数长度限制")
    private String lengthLimit;
    @ExcelProperty("说明")
    private String description;
}
