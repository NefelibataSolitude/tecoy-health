/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 14:43
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import net.tecoy.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    /**
     * 通过日期查询体检预约
     * @param date
     * @return
     */
    Order selectByOrderDate(Date date);

    /**
     * 条件查询
     * @param order
     * @return
     */
    List<Order> selectByCondition(Order order);

    /**
     * 新增体检预约
     * @param order
     * @return
     */
    int add(Order order);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Map<String, Object> selectById(@Param("id") Integer id);

    /**
     * 条件统计数据
     * @param startTime
     * @param endTime
     * @param orderStatus
     * @return
     */
    int countOrderByCondition(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("orderStatus") String orderStatus);

    /**
     * 查询热门套餐
     * @return
     */
    List<Map<String, Object>> selectSetmealBySort();
}
