create table t_role
(
    id          int auto_increment
        primary key,
    name        varchar(32)  null,
    keyword     varchar(64)  null,
    description varchar(128) null
);

INSERT INTO health.t_role (id, name, keyword, description) VALUES (1, '系统管理员', 'ROLE_ADMIN', null);
INSERT INTO health.t_role (id, name, keyword, description) VALUES (2, '健康管理师', 'ROLE_HEALTH_MANAGER', null);