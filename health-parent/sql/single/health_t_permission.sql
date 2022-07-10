create table t_permission
(
    id          int auto_increment
        primary key,
    name        varchar(32)  null,
    keyword     varchar(64)  null,
    description varchar(128) null
);

INSERT INTO health.t_permission (id, name, keyword, description) VALUES (1, '新增检查项', 'CHECKITEM_ADD', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (2, '删除检查项', 'CHECKITEM_DELETE', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (3, '编辑检查项', 'CHECKITEM_EDIT', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (4, '查询检查项', 'CHECKITEM_QUERY', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (5, '新增检查组', 'CHECKGROUP_ADD', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (6, '删除检查组', 'CHECKGROUP_DELETE', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (7, '编辑检查组', 'CHECKGROUP_EDIT', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (8, '查询检查组', 'CHECKGROUP_QUERY', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (9, '新增套餐', 'SETMEAL_ADD', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (10, '删除套餐', 'SETMEAL_DELETE', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (11, '编辑套餐', 'SETMEAL_EDIT', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (12, '查询套餐', 'SETMEAL_QUERY', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (13, '预约设置', 'ORDERSETTING', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (14, '查看统计报表', 'REPORT_VIEW', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (15, '新增菜单', 'MENU_ADD', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (16, '删除菜单', 'MENU_DELETE', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (17, '编辑菜单', 'MENU_EDIT', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (18, '查询菜单', 'MENU_QUERY', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (19, '新增角色', 'ROLE_ADD', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (20, '删除角色', 'ROLE_DELETE', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (21, '编辑角色', 'ROLE_EDIT', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (22, '查询角色', 'ROLE_QUERY', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (23, '新增用户', 'USER_ADD', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (24, '删除用户', 'USER_DELETE', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (25, '编辑用户', 'USER_EDIT', null);
INSERT INTO health.t_permission (id, name, keyword, description) VALUES (26, '查询用户', 'USER_QUERY', null);