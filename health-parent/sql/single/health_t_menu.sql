create table t_menu
(
    id           int auto_increment
        primary key,
    name         varchar(128) null,
    linkUrl      varchar(128) null,
    path         varchar(128) null,
    priority     int          null,
    icon         varchar(64)  null,
    description  varchar(128) null,
    parentMenuId int          null,
    level        int          null,
    constraint FK_Reference_13
        foreign key (parentMenuId) references t_menu (id)
);

INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (1, '会员管理', null, '2', 1, 'fa-user-md', null, null, 1);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (2, '会员档案', 'member.html', '/2-1', 1, null, null, 1, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (3, '体检上传', null, '/2-2', 2, null, null, 1, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (4, '会员统计', null, '/2-3', 3, null, null, 1, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (5, '预约管理', null, '3', 2, 'fa-tty', null, null, 1);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (6, '预约列表', 'ordersettinglist.html', '/3-1', 1, null, null, 5, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (7, '预约设置', 'ordersetting.html', '/3-2', 2, null, null, 5, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (8, '套餐管理', 'setmeal.html', '/3-3', 3, null, null, 5, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (9, '检查组管理', 'checkgroup.html', '/3-4', 4, null, null, 5, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (10, '检查项管理', 'checkitem.html', '/3-5', 5, null, null, 5, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (11, '健康评估', null, '4', 3, 'fa-stethoscope', null, null, 1);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (12, '中医体质辨识', null, '/4-1', 1, null, null, 11, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (13, '统计分析', null, '5', 4, 'fa-heartbeat', null, null, 1);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (14, '会员数量', 'report_member.html', '/5-1', 1, null, null, 13, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (15, '系统设置', null, '6', 5, 'fa-users', null, null, 1);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (16, '菜单管理', 'menu.html', '/6-1', 1, null, null, 15, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (17, '权限管理', 'permission.html', '/6-2', 2, null, null, 15, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (18, '角色管理', 'role.html', '/6-3', 3, null, null, 15, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (19, '用户管理', 'user.html', '/6-4', 4, null, null, 15, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (20, '套餐占比', 'report_setmeal.html', '/5-2', 2, null, null, 13, 2);
INSERT INTO health.t_menu (id, name, linkUrl, path, priority, icon, description, parentMenuId, level) VALUES (21, '运营数据', 'report_business.html', '/5-3', 3, null, null, 13, 2);