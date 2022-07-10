create table t_order
(
    id          int auto_increment
        primary key,
    member_id   int        null comment '员会id',
    orderDate   date       null comment '约预日期',
    orderType   varchar(8) null comment '约预类型 电话预约/微信预约',
    orderStatus varchar(8) null comment '预约状态（是否到诊）',
    setmeal_id  int        null comment '餐套id',
    constraint key_member_id
        foreign key (member_id) references t_member (id),
    constraint key_setmeal_id
        foreign key (setmeal_id) references t_setmeal (id)
);

INSERT INTO health.t_order (id, member_id, orderDate, orderType, orderStatus, setmeal_id) VALUES (18, 94, '2022-07-14', '微信预约', '未到诊', 19);
INSERT INTO health.t_order (id, member_id, orderDate, orderType, orderStatus, setmeal_id) VALUES (19, 94, '2022-07-16', '微信预约', '未到诊', 19);
INSERT INTO health.t_order (id, member_id, orderDate, orderType, orderStatus, setmeal_id) VALUES (20, 94, '2022-07-10', '微信预约', '未到诊', 20);
INSERT INTO health.t_order (id, member_id, orderDate, orderType, orderStatus, setmeal_id) VALUES (21, 94, '2022-07-10', '微信预约', '已到诊', 22);