/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 14:35
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.mapper.MemberMapper;
import net.tecoy.mapper.OrderMapper;
import net.tecoy.mapper.OrderSettingMapper;
import net.tecoy.pojo.Member;
import net.tecoy.pojo.Order;
import net.tecoy.pojo.OrderSetting;
import net.tecoy.service.OrderService;
import net.tecoy.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderService.class)
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderSettingMapper orderSettingMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Result add(Map<String, String> map) throws Exception {
        // 检查预约日期是否进行了预约设置
        String orderDate = map.get("orderDate");
        OrderSetting orderSetting = orderSettingMapper.selectByOrderDate(DateUtils.parseString2Date(orderDate));
        if (orderSetting == null) {
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }
        // 检查预约日期是否还可预约
        int number = orderSetting.getNumber();
        int reservations = orderSetting.getReservations();
        if (reservations >= number) {
            return new Result(false, MessageConstant.ORDER_FULL);
        }
        // 是否为重复预约
        String telephone = map.get("telephone");
        Member member = memberMapper.selectByTelephone(telephone);
        if (member != null) {
            // 判断是否重复预约
            Integer id = member.getId();
            Date date = DateUtils.parseString2Date(orderDate);
            Integer setmealId = Integer.valueOf(map.get("setmealId"));
            Order order = new Order(id, date, setmealId);
            // 根据条件查询
            List<Order> orders = orderMapper.selectByCondition(order);
            if (orders != null && orders.size() > 0) {
                // 说明重复预约
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
        } else {
            // 检查当前用户是否为会员, 不是自动注册在进行预约
            member = new Member();
            member.setName(map.get("name"));
            member.setSex(map.get("sex"));
            member.setPhoneNumber(telephone);
            member.setIdCard(map.get("idCard"));
            member.setRegTime(new Date());
            // 设置默认密码为身份证后六位

            memberMapper.add(member);
        }
        // 预约成功, 更新当日的预约人数
        Order order = new Order();
        order.setMemberId(member.getId());
        order.setOrderDate(DateUtils.parseString2Date(orderDate));
        order.setOrderType(map.get("orderType"));
        order.setOrderStatus(Order.ORDERSTATUS_NO);
        order.setSetmealId(Integer.valueOf(map.get("setmealId")));
        orderMapper.add(order);
        // 更新预约人数
        orderSetting.setReservations(orderSetting.getReservations() + 1);
        orderSettingMapper.editByOrderDate(orderSetting);
        return new Result(true, MessageConstant.ORDER_SUCCESS, order.getId());
    }


    @Override
    public Map<String, Object> selectById(Integer id) throws Exception {
        Map<String, Object> map = orderMapper.selectById(id);
        if (map != null ) {
            Date orderDate = (Date) map.get("orderDate");
            map.put("orderDate", DateUtils.parseDate2String(orderDate));
        }
        return map;
    }
}
