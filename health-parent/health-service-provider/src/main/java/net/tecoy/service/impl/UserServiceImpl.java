/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 22:40
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import net.tecoy.mapper.PermissionMapper;
import net.tecoy.mapper.RoleMapper;
import net.tecoy.mapper.UserMapper;
import net.tecoy.pojo.Permission;
import net.tecoy.pojo.Role;
import net.tecoy.pojo.User;
import net.tecoy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service(interfaceClass = UserService.class)
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User selectByName(String name) {
        User user = userMapper.selectByName(name);
        if (user == null) {
            return null;
        }
        Integer userId = user.getId();
        // 根据用户id查询角色
        Set<Role> roles = roleMapper.selectByUserId(userId);
        // 根据角色查询权限
        for (Role role : roles) {
            Integer roleId = role.getId();
            Set<Permission> permissions = permissionMapper.selectByRoleId(roleId);
            role.setPermissions(permissions);
        }
        user.setRoles(roles);
        return user;
    }
}
