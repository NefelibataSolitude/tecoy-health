/**
 * @Author: Tecoy
 * @Contact: itecoy@163.com
 * @Date: 2022/7/10 14:14
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import net.tecoy.mapper.MemberMapper;
import net.tecoy.mapper.OrderMapper;
import net.tecoy.pojo.Order;
import net.tecoy.service.ReportService;
import net.tecoy.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(interfaceClass = ReportService.class)
@Transactional(rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Map<String, Object> BusinessReport() throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 日期
        String today = DateUtils.parseDate2String(DateUtils.getToday());
        data.put("reportDate", today);
        // 今日新增会员数
        int todayNewMember = memberMapper.countMemberByDate(today, today);
        data.put("todayNewMember", todayNewMember);
        // 总会员数
        int totalMember = memberMapper.countTotal();
        data.put("totalMember", totalMember);
        // 本周新增会员数
        // 动态获得本周一的日期
        String thisWeekMonday = DateUtils.parseDate2String(DateUtils.getThisWeekMonday());
        int thisWeekNewMember = memberMapper.countMemberByDate(thisWeekMonday, null);
        data.put("thisWeekNewMember", thisWeekNewMember);
        // 本月新增会员数
        String thisFirstDay = DateUtils.parseDate2String(DateUtils.getFirstDay4ThisMonth());
        int thisMonthNewMember = memberMapper.countMemberByDate(thisFirstDay, null);
        data.put("thisMonthNewMember", thisMonthNewMember);
        // 今日预约数
        int todayOrderNumber = orderMapper.countOrderByCondition(today, today, null);
        data.put("todayOrderNumber", todayOrderNumber);
        // 今日到诊人数
        int todayVisitsNumber = orderMapper.countOrderByCondition(today, today, Order.ORDERSTATUS_YES);
        data.put("todayVisitsNumber", todayVisitsNumber);
        // 本周预约人数
        int thisWeekOrderNumber = orderMapper.countOrderByCondition(thisWeekMonday, null, null);
        data.put("thisWeekOrderNumber", thisWeekOrderNumber);
        // 本周到诊人数
        int thisWeekVisitsNumber = orderMapper.countOrderByCondition(thisWeekMonday, null, Order.ORDERSTATUS_YES);
        data.put("thisWeekVisitsNumber", thisWeekVisitsNumber);
        // 本月预约人数
        int thisMonthOrderNumber = orderMapper.countOrderByCondition(thisFirstDay, null, null);
        data.put("thisMonthOrderNumber", thisMonthOrderNumber);
        // 本月到诊人数
        int thisMonthVisitsNumber = orderMapper.countOrderByCondition(thisFirstDay, null, Order.ORDERSTATUS_YES);
        data.put("thisMonthVisitsNumber", thisMonthVisitsNumber);
        // 热门套餐
        List<Map<String, Object>> hotSetmeal = orderMapper.selectSetmealBySort();
        data.put("hotSetmeal", hotSetmeal);
        return data;
    }
}
