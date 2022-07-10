/**
 * @Author: Tecoy
 * @Contact: itecoy@163.com
 * @Date: 2022/7/10 14:11
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import java.util.Map;

/**
 * 运营数据统计
 * @author Tecoy
 */
public interface ReportService {

    /**
     * 运营数据统计
     * @return
     */
    Map<String, Object> BusinessReport() throws Exception;
}
