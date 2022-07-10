create table t_role_menu
(
    role_id int not null,
    menu_id int not null,
    primary key (role_id, menu_id),
    constraint FK_Reference_10
        foreign key (menu_id) references t_menu (id),
    constraint FK_Reference_9
        foreign key (role_id) references t_role (id)
);

INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 1);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (2, 1);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 2);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (2, 2);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 3);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (2, 3);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 4);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (2, 4);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 5);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 6);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 7);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 8);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 9);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 10);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 11);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 12);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 13);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 14);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 15);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 16);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 17);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 18);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 19);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 20);
INSERT INTO health.t_role_menu (role_id, menu_id) VALUES (1, 21);