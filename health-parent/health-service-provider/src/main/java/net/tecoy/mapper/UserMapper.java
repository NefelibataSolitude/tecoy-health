/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 22:42
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import net.tecoy.pojo.User;

public interface UserMapper {
    /**
     * 通过用户名查询用户信息
     * @param name
     * @return
     */
    User selectByName(String name);
}
