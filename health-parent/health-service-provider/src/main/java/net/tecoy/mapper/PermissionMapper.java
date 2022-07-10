/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 22:50
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import net.tecoy.pojo.Permission;
import java.util.Set;

/**
 * 权限管理
 * @author Tecoy
 */
public interface PermissionMapper {
    /**
     * 通过角色id查询权限集合
     * @param roleId
     * @return
     */
    Set<Permission> selectByRoleId(Integer roleId);
}
