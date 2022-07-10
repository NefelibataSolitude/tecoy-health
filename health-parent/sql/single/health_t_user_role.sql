create table t_user_role
(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint FK_Reference_7
        foreign key (user_id) references t_user (id),
    constraint FK_Reference_8
        foreign key (role_id) references t_role (id)
);

INSERT INTO health.t_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO health.t_user_role (user_id, role_id) VALUES (2, 2);