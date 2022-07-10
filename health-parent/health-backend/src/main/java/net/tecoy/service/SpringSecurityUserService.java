/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 22:23
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.pojo.Permission;
import net.tecoy.pojo.Role;
import net.tecoy.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 权限认证与授权
 * @author Tecoy
 */
@Component
public class SpringSecurityUserService implements UserDetailsService {

    /**
     * 使用dubbo远程调用服务查询数据库信息
     */
    @Reference
    private UserService userService;

    /**
     * 根据用户名查询数据获取用户信息
     * @param name
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.selectByName(name);
        if (user == null) {
            // 用户名不存在
            return null;
        }

        List<GrantedAuthority> list = new ArrayList<>();
        // 动态为用户授权
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            // 遍历角色集合, 为用户角色授权
            list.add(new SimpleGrantedAuthority(role.getKeyword()));
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                // 遍历权限集合, 为用户授权
                list.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(name, user.getPassword(), list);
        return securityUser;
    }
}
