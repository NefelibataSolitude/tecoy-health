create table t_checkgroup
(
    id        int auto_increment
        primary key,
    code      varchar(32)  null,
    name      varchar(32)  null,
    helpCode  varchar(32)  null,
    sex       char         null,
    remark    varchar(128) null,
    attention varchar(128) null
);

INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (5, '0001', '一般检查', 'YBJC', '0', '一般检查', '无');
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (6, '0002', '视力色觉', 'SLSJ', '0', '视力色觉', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (7, '0003', '血常规', 'XCG', '0', '血常规', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (8, '0004', '尿常规', 'NCG', '0', '尿常规', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (9, '0005', '肝功三项', 'GGSX', '0', '肝功三项', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (10, '0006', '肾功三项', 'NGSX', '0', '肾功三项', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (11, '0007', '血脂四项', 'XZSX', '0', '血脂四项', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (12, '0008', '心肌酶三项', 'XJMSX', '0', '心肌酶三项', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (13, '0009', '甲功三项', 'JGSX', '0', '甲功三项', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (14, '0010', '子宫附件彩超', 'ZGFJCC', '2', '子宫附件彩超', null);
INSERT INTO health.t_checkgroup (id, code, name, helpCode, sex, remark, attention) VALUES (15, '0011', '胆红素三项', 'DHSSX', '0', '胆红素三项', null);