/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 22:27
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import net.tecoy.pojo.User;

/**
 * 管理用户信息
 * @author Tecoy
 */
public interface UserService {

    /**
     * 通过用户名查询用户信息
     * @param name
     * @return
     */
    User selectByName(String name);
}
