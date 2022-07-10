create table t_user
(
    id        int auto_increment
        primary key,
    birthday  date         null,
    gender    varchar(1)   null,
    username  varchar(32)  null,
    password  varchar(256) null,
    remark    varchar(32)  null,
    station   varchar(1)   null,
    telephone varchar(11)  null
);

INSERT INTO health.t_user (id, birthday, gender, username, password, remark, station, telephone) VALUES (1, null, null, 'admin', '$2a$10$u/BcsUUqZNWUxdmDhbnoeeobJy6IBsL1Gn/S0dMxI2RbSgnMKJ.4a', null, null, null);
INSERT INTO health.t_user (id, birthday, gender, username, password, remark, station, telephone) VALUES (2, null, null, 'test', '$2a$10$3xW2nBjwBM3rx1LoYprVsemNri5bvxeOd/QfmO7UDFQhW2HRHLi.C', null, null, null);