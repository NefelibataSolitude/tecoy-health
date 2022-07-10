/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 22:46
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;


import net.tecoy.pojo.Role;

import java.util.Set;

/**
 * 管理角色
 * @author Tecoy
 */
public interface RoleMapper {
    /**
     * 通过用户id查询角色集合
     * @param userId
     * @return
     */
    Set<Role> selectByUserId(Integer userId);
}
