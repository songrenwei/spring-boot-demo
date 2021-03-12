package com.srw.common.component.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/1/7 15:37
 */
@Data
@Builder
public class DataModel {

    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;

}
