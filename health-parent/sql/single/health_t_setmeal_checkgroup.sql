create table t_setmeal_checkgroup
(
    setmeal_id    int default 0 not null,
    checkgroup_id int default 0 not null,
    primary key (setmeal_id, checkgroup_id),
    constraint checkgroup_key
        foreign key (checkgroup_id) references t_checkgroup (id),
    constraint setmeal_key
        foreign key (setmeal_id) references t_setmeal (id)
);

INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 5);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 5);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (23, 5);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 6);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 6);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (23, 6);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 7);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (21, 7);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 8);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (21, 8);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 8);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 9);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 9);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 10);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 10);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 11);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 11);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (21, 11);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 11);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 12);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 12);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (21, 12);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 13);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 13);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 13);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (19, 14);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 14);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (20, 15);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (21, 15);
INSERT INTO health.t_setmeal_checkgroup (setmeal_id, checkgroup_id) VALUES (22, 15);