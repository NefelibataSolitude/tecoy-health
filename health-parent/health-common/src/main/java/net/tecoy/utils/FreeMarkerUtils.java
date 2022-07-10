/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/8 23:04
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 生成静态文件
 * @author Tecoy
 */
public class FreeMarkerUtils {
    public static void generateHtml(FreeMarkerConfigurer freeMarkerConfigurer,
                                    String outputPath,
                                    String templateName,
                                    String htmlPageName,
                                    Map<String, Object> dataMap) {
        // 获得配置对象
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Writer out = null;
        // 模板对象
        try {
            Template template = configuration.getTemplate(templateName);
            out = new FileWriter(outputPath + "/" +htmlPageName);
            // 输出文件
            template.process(dataMap, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
