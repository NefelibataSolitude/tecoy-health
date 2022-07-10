/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 23:58
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/getUsername")
    public Result getUsername() {
        // 当springsecurity完成认证, 会将用户信息保存到上下文对象
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            String username = user.getUsername();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS, username);
        }
        return new Result(false, MessageConstant.GET_USERNAME_FAIL);
    }
}
