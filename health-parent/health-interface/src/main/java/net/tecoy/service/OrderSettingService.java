/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/7 21:04
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import net.tecoy.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * 预约设置
 * @author Tecoy
 */
public interface OrderSettingService {
    /**
     * 批量添加预约设置
     * @param list
     * @return
     */
    boolean add(List<OrderSetting> list);

    /**
     * 根据月份查询预约设置
     * @param date
     * @return
     */
    List<Map<String, Object>> getOrderSettingByMonth(String date);

    /**
     * 根据日期修改可预约人数
     * @param orderSetting
     * @return
     */
    boolean editNumberByDate(OrderSetting orderSetting);
}
