/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/7 21:15
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import net.tecoy.mapper.OrderSettingMapper;
import net.tecoy.pojo.OrderSetting;
import net.tecoy.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(interfaceClass = OrderSettingService.class)
@Transactional(rollbackFor = Exception.class)
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OrderSettingMapper orderSettingMapper;

    @Override
    public boolean add(List<OrderSetting> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (OrderSetting orderSetting : list) {
            long count = orderSettingMapper.countByOrderDate(orderSetting.getOrderDate());
            if (count > 0) {
                // 已经进行了更新操作, 更新
                orderSettingMapper.editByOrderDate(orderSetting);
            } else {
                // 添加预约设置
                orderSettingMapper.add(orderSetting);
            }
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> getOrderSettingByMonth(String date) {
        String begin = date + "-1";
        String end = date + "-31";
        Map<String, String> map = new HashMap<>();
        map.put("begin", begin);
        map.put("end", end);
        List<OrderSetting> list = orderSettingMapper.selectOrderSettingByMonth(map);
        if (list == null || list.size() == 0) {
            return null;
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (OrderSetting orderSetting : list) {
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("date", orderSetting.getOrderDate().getDate());
            objectMap.put("number", orderSetting.getNumber());
            objectMap.put("reservations", orderSetting.getReservations());
            result.add(objectMap);
        }
        return result;
    }

    @Override
    public boolean editNumberByDate(OrderSetting orderSetting) {
        Date orderDate = orderSetting.getOrderDate();
        long count = orderSettingMapper.countByOrderDate(orderDate);
        int number = 0;
        if (count > 0) {
            // 更新
            number = orderSettingMapper.editByOrderDate(orderSetting);
        } else {
            // 插入
            number = orderSettingMapper.add(orderSetting);
        }
        return number > 0;
    }
}
