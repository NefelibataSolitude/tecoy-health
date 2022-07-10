/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 11:34
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.exceptions.ClientException;
import net.tecoy.constant.MessageConstant;
import net.tecoy.constant.RedisMessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.pojo.Order;
import net.tecoy.service.OrderService;
import net.tecoy.utils.SMSUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * 体检预约
 * @author Tecoy
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final JedisPool jedisPool;
    @Reference
    private OrderService orderService;

    public OrderController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    /**
     * 体检预约
     * @param map
     * @return
     */
    @RequestMapping("/submit")
    public Result submit(@RequestBody Map<String, String> map) {
        String telephone = map.get("telephone");
        String code = map.get("validateCode");
        // 检校验证码
        String realCode = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_ORDER);
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(realCode) || !code.equals(realCode)) {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
        map.put("orderType", Order.ORDERTYPE_WEIXIN);
        Result result = new Result(false, MessageConstant.ORDERSETTING_FAIL);
        try {
            result = orderService.add(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.isFlag()) {
            // 预约成功, 发送短信
//            try {
//                SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE, telephone, map.get("orderDate"));
//            } catch (ClientException e) {
//                e.printStackTrace();
//            }
            System.out.println("预约成功!");
        }
        return result;
    }

    /**
     * 通过id查询体检预约详情
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Map<String, Object> map = orderService.selectById(id);
            return new Result(map != null, map != null ? MessageConstant.ORDER_SUCCESS : MessageConstant.QUERY_ORDER_FAIL, map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ORDER_FAIL);
        }
    }


}
