
// 声明当前类所在的包
package com.d7g.d7gback.config;

// 引入 Lombok 的日志注解，用于简化日志记录
import lombok.extern.slf4j.Slf4j;
// 引入 Excel 解析上下文类，用于在解析过程中获取上下文信息
import cn.idev.excel.context.AnalysisContext;
// 引入 Excel 解析事件监听器接口，用于监听 Excel 解析事件
import cn.idev.excel.event.AnalysisEventListener;
// 引入阿里巴巴的 JSON 处理工具，用于将对象转换为 JSON 字符串
import com.alibaba.fastjson.JSON;
// 引入 Java 的 ArrayList 类，用于存储数据
import java.util.ArrayList;
// 引入 Java 的 List 接口，用于定义数据存储的集合类型
import java.util.List;

// 引入自定义的 Excel 数据模型类
import com.d7g.d7gback.models.ExcelDemoModel;

/**
 * 使用 Lombok 的 @Slf4j 注解为类添加日志功能
 * 该类继承自 AnalysisEventListener，用于监听 Excel 解析事件
 */
@Slf4j
public class ExcelUploadDataListener extends AnalysisEventListener<ExcelDemoModel> {
    /**
     * 用于存储解析后的 Excel 数据
     * 使用 ArrayList 来存储 ExcelDemoModel 类型的数据
     */
    private final List<ExcelDemoModel> list = new ArrayList<>();

    /**
     * 当解析到一行数据时触发该方法
     * @param data 解析到的 Excel 数据行，类型为 ExcelDemoModel
     * @param context 解析上下文，包含解析过程中的相关信息
     */
    @Override
    public void invoke(ExcelDemoModel data, AnalysisContext context) {
        // 记录解析到的一条数据的 JSON 格式信息
        log.info("解析到一条数据: {}", JSON.toJSONString(data));
        // 将解析到的数据添加到列表中
        list.add(data);
    }

    /**
     * 当所有数据解析完成后触发该方法
     * @param context 解析上下文，包含解析过程中的相关信息
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 记录所有数据解析完成的信息
        log.info("所有数据解析完成！");
        // 在此处可以进行数据的存储操作，如保存到数据库
    }
}