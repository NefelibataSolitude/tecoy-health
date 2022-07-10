create table t_checkgroup_checkitem
(
    checkgroup_id int default 0 not null,
    checkitem_id  int default 0 not null,
    primary key (checkgroup_id, checkitem_id),
    constraint group_id
        foreign key (checkgroup_id) references t_checkgroup (id),
    constraint item_id
        foreign key (checkitem_id) references t_checkitem (id)
);

INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (5, 28);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (5, 29);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (5, 30);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (5, 31);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (5, 32);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (6, 33);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (6, 34);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (6, 35);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (6, 36);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (6, 37);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 38);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 39);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 40);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 41);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 42);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 43);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 44);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 45);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 46);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 47);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 48);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 49);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 50);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 51);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 52);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 53);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 54);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 55);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (7, 56);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 57);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 58);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 59);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 60);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 61);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 62);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 63);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 64);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 65);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 66);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 67);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 68);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 69);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 70);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (8, 71);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (9, 72);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (9, 73);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (9, 74);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (10, 75);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (10, 76);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (10, 77);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (11, 78);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (11, 79);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (11, 80);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (11, 81);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (12, 82);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (12, 83);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (12, 84);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (13, 85);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (13, 86);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (13, 87);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (14, 88);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (14, 89);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (15, 90);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (15, 91);
INSERT INTO health.t_checkgroup_checkitem (checkgroup_id, checkitem_id) VALUES (15, 92);