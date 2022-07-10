# tecoy-health

资料来源: 哔哩哔哩 – 黑马程序员

# 项目准备

**技术栈**

主要技术栈: SSH + Zookeeper + Dubbo + Spring Secutity

详细: 

- 后端技术

  - SSH
  - Tomcat

  - Zookeeper + Dubbo

  - Spring Secutity
  - POI
  - JasperReports
  - Quartz

- 存储

  - MySQL
  - Redis(缓存)
  - 七牛云(存储图片)

- 前端技术

  - vue.js
  - ElementUI
  - Echarts

**项目结构**

- 后端管理工程`health-backend`
- 手机端工程`health-mobile`
- 服务提供端`health-service-provider`
- Quartz定时清理七牛云存储的图片`health-jobs`
- 服务接口`health-interface`
- 公共文件`health-common`

# 快速开始

1. 创建数据库`health.sql`

2. 修改`MySQL`, `Redis`配置

   - `spring-redis.xml`

   - `spring-mapper.xml`
   - `applicationContext-redis.xml`
   - `redis.properties`

3. 修改Dubbo配置

4. 修改七牛云存储配置`QiniuUtils`

   ```java
   private static String accessKey = "";
   private static String secretKey = "";
   ```

5. 主要启动项

   1. 后端管理工程`health-backend`
   2. 手机端工程`health-mobile`
   3. 服务提供端`health-service-provider`
   4. Quartz定时清理七牛云存储的图片`health-jobs`



# 项目详解

## `health-service-provider`

为整个项目提供服务, 把服务注册到zookeeper注册中心, 供其他项目使用



## `health-backend`







# `health-mobile`

通过uartz定时清理七牛云存储的图片





# `health-jobs`







# `Spring Secutity`详解

通过Spring Secutity对后台信息管理人员进行权限控制

- 导入依赖

  ```xml
  <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
    <version>5.0.5.RELEASE</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
    <version>5.0.5.RELEASE</version>
  </dependency>
  ```

- 配置文件`spring-security.xml`

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:security="http://www.springframework.org/schema/security"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/security
                            http://www.springframework.org/schema/security/spring-security.xsd">
  
      <!--
         http：用于定义相关权限控制
         指定哪些资源不需要进行权限校验，可以使用通配符
     -->
      <!--匿名访问页面配置-->
      <security:http security="none" pattern="/login.html"/>
      <security:http security="none" pattern="/css/**"/>
      <security:http security="none" pattern="/img/**"/>
      <security:http security="none" pattern="/js/**"/>
      <security:http security="none" pattern="/plugins/**"/>
  
  
      <!--
          http：用于定义相关权限控制
          auto-config：是否自动配置
                          设置为true时框架会提供默认的一些配置，例如提供默认的登录页面、登出处理等
                          设置为false时需要显示提供登录表单配置，否则会报错
          use-expressions：用于指定intercept-url中的access属性是否使用表达式
      -->
      <security:http auto-config="true" use-expressions="true">
          <security:headers>
              <!--设置在页面可以通过iframe访问受保护的页面，默认为不允许访问-->
              <security:frame-options policy="SAMEORIGIN"></security:frame-options>
          </security:headers>
          <!--
             intercept-url：定义一个拦截规则
             pattern：对哪些url进行权限控制
             access：在请求对应的URL时需要什么权限，默认配置时它应该是一个以逗号分隔的角色列表，
                   请求的用户只需拥有其中的一个角色就能成功访问对应的URL
             isAuthenticated()：已经经过认证（不是匿名用户）
         -->
          <security:intercept-url pattern="/pages/**" access="isAuthenticated()"/>
          <!--form-login：定义表单登录信息-->
          <security:form-login login-page="/login.html"
                               username-parameter="username"
                               password-parameter="password"
                               login-processing-url="/login.do"
                               default-target-url="/pages/main.html"
                               authentication-failure-url="/login.html"/>
          <!--
              csrf：对应CsrfFilter过滤器
              disabled：是否启用CsrfFilter过滤器，如果使用自定义登录页面需要关闭此项，
                 否则登录操作会被禁用（403）
          -->
          <security:csrf disabled="true"/>
          <!--
            logout：退出登录
            logout-url：退出登录操作对应的请求路径
            logout-success-url：退出登录后的跳转页面
          -->
          <security:logout logout-url="/logout.do"
                           logout-success-url="/login.html" invalidate-session="true"/>
      </security:http>
      <!--配置密码加密对象-->
      <bean id="passwordEncoder"
            class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />
  
      <!--认证管理器，用于处理认证操作-->
      <security:authentication-manager>
          <!--认证提供者，执行具体的认证逻辑-->
          <security:authentication-provider user-service-ref="springSecurityUserService">
              <!--指定密码加密策略-->
              <security:password-encoder ref="passwordEncoder" />
          </security:authentication-provider>
      </security:authentication-manager>
  
      <!--开启注解方式权限控制-->
      <security:global-method-security pre-post-annotations="enabled" />
  </beans>
  ```

- 编写权限认证与授权服务(通过数据库)

  ```java
  **
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
  ```

- 在Controller中添加权限访问控制

  ```java
  @PreAuthorize("hasAuthority('CHECKITEM_DELETE')")
  ```









# 总结



