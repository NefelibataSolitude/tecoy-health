create table t_role_permission
(
    role_id       int not null,
    permission_id int not null,
    primary key (role_id, permission_id),
    constraint FK_Reference_11
        foreign key (role_id) references t_role (id),
    constraint FK_Reference_12
        foreign key (permission_id) references t_permission (id)
);

INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 1);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 2);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 3);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 3);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 4);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 4);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 5);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 5);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 6);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 6);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 7);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 7);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 8);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 8);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 9);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 9);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 10);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 10);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 11);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 11);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 12);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 12);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 13);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 13);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 14);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (2, 14);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 15);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 16);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 17);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 18);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 19);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 20);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 21);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 22);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 23);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 24);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 25);
INSERT INTO health.t_role_permission (role_id, permission_id) VALUES (1, 26);