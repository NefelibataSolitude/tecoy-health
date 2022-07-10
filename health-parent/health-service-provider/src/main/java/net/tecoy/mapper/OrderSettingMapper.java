/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/7 21:15
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import net.tecoy.pojo.OrderSetting;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingMapper {

    /**
     * 批量添加预约设置
     * @param orderSetting
     * @return
     */
    int add(OrderSetting orderSetting);

    /**
     * 根据日期统计数据
     * @param orderDate
     * @return
     */
    long countByOrderDate(Date orderDate);

    /**
     * 根据日期修改数据
     * @param orderSetting
     * @return
     */
    int editByOrderDate(OrderSetting orderSetting);

    /**
     * 根据月份查询预约设置
     * @param map
     * @return
     */
    List<OrderSetting> selectOrderSettingByMonth(Map<String, String> map);

    /**
     * 通过预约日期查询
     * @param orderDate
     * @return
     */
    OrderSetting selectByOrderDate(Date orderDate);

}
