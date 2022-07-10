/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 11:02
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.aliyuncs.exceptions.ClientException;
import net.tecoy.constant.MessageConstant;
import net.tecoy.constant.RedisMessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.utils.SMSUtils;
import net.tecoy.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    private final JedisPool jedisPool;

    public ValidateCodeController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 用户体检预约发送验证码
     * @param telephone
     * @return
     */
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        // 生成验证码
        Integer code = ValidateCodeUtils.generateValidateCode(4);
        // 发送验证码
//        try {
//            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, telephone, code.toString());
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
//        }
        System.out.println("体检预约验证码(5分钟有效): " + code);
        // 存储验证码到redis(5分钟)
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 300, code.toString());
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

    /**
     * 登录发送验证码
     * @param telephone
     * @return
     */
    @RequestMapping("/send6Login")
    public Result send6Login(String telephone) {
        // 生成验证码
        Integer code = ValidateCodeUtils.generateValidateCode(6);
        // 发送验证码
//        try {
//            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, telephone, code.toString());
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
//        }
        System.out.println("体检预约验证码(5分钟有效): " + code);
        // 存储验证码到redis(5分钟)
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN, 300, code.toString());
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }
}
