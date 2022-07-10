/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 18:08
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import net.tecoy.constant.MessageConstant;
import net.tecoy.constant.RedisMessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.pojo.Member;
import net.tecoy.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final JedisPool jedisPool;
    @Reference
    private MemberService memberService;

    public MemberController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 登录
     * @param response
     * @param info
     * @return
     */
    @RequestMapping("/login")
    public Result login(HttpServletResponse response, @RequestBody Map<String, String> info) {
        String telephone = info.get("telephone");
        String code = info.get("validateCode");
        String realCode = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_LOGIN);
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(realCode) || !code.equals(realCode)) {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
        // 查询是否为会员
        Member member = memberService.selectByTelephone(telephone);
        if (member == null) {
            // 不是会员, 自动完成注册
            member = new Member();
            member.setRegTime(new Date());
            member.setPhoneNumber(telephone);
            member.setName(UUID.randomUUID().toString());
            memberService.add(member);
        }
        // 写入cookie
        Cookie cookie = new Cookie("login_member_telephone", telephone);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        // 将会员信息保存到redis
        String json = JSON.toJSON(member).toString();
        jedisPool.getResource().setex(telephone, 60*30, json);
        return new Result(true, MessageConstant.LOGIN_SUCCESS);
    }
}
