/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/7 20:58
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.pojo.OrderSetting;
import net.tecoy.service.OrderSettingService;
import net.tecoy.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 预约设置
 *
 * @author Tecoy
 */
@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {

    @Reference
    private OrderSettingService orderSettingService;

    /**
     * 批量导入数据
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("excelFile") MultipartFile file) {
        boolean flag = false;
        try {
            List<OrderSetting> list = new ArrayList<>();
            // poi解析数据
            List<String[]> excel = POIUtils.readExcel(file);
            for (String[] content : excel) {
                Date orderDate = new Date(content[0]);
                String number = content[1];
                OrderSetting orderSetting = new OrderSetting(orderDate, Integer.parseInt(number));
                list.add(orderSetting);
            }
            // 通过dubbo远程调用批量添加数据
            flag = orderSettingService.add(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.IMPORT_ORDERSETTING_SUCCESS : MessageConstant.IMPORT_ORDERSETTING_FAIL);
    }


    /**
     * 根据月份查询预约设置
     * @param date yyyy-MM
     * @return
     */
    @RequestMapping("/getOrderSettingByMonth")
    public Result getOrderSettingByMonth(String date) {
        try {
            List<Map<String, Object>> list = orderSettingService.getOrderSettingByMonth(date);
            return new Result(true, MessageConstant.GET_ORDERSETTING_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_ORDERSETTING_FAIL);
        }
    }

    /**
     *
     * @param orderSetting
     * @return
     */
    @RequestMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting orderSetting) {
        boolean flag = false;
        try {
            flag = orderSettingService.editNumberByDate(orderSetting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.ORDERSETTING_FAIL : MessageConstant.ORDERSETTING_FAIL);
    }
}
