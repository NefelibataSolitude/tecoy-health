create table t_checkitem
(
    id        int auto_increment
        primary key,
    code      varchar(16)  null,
    name      varchar(32)  null,
    sex       char         null,
    age       varchar(32)  null,
    price     float        null,
    type      char         null comment '查检项类型,分为检查和检验两种',
    attention varchar(128) null,
    remark    varchar(128) null
);

INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (28, '0001', '身高', '0', '0-100', 5, '1', '无', '身高');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (29, '0002', '体重', '0', '0-100', 5, '1', '无', '体重');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (30, '0003', '体重指数', '0', '0-100', 5, '1', '无', '体重指数');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (31, '0004', '收缩压', '0', '0-100', 5, '1', '无', '收缩压');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (32, '0005', '舒张压', '0', '0-100', 5, '1', '无', '舒张压');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (33, '0006', '裸视力（右）', '0', '0-100', 5, '1', '无', '裸视力（右）');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (34, '0007', '裸视力（左）', '0', '0-100', 5, '1', '无', '裸视力（左）');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (35, '0008', '矫正视力（右）', '0', '0-100', 5, '1', '无', '矫正视力（右）');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (36, '0009', '矫正视力（左）', '0', '0-100', 5, '1', '无', '矫正视力（左）');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (37, '0010', '色觉', '0', '0-100', 5, '1', '无', '色觉');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (38, '0011', '白细胞计数', '0', '0-100', 10, '2', '无', '白细胞计数');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (39, '0012', '红细胞计数', '0', '0-100', 10, '2', null, '红细胞计数');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (40, '0013', '血红蛋白', '0', '0-100', 10, '2', null, '血红蛋白');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (41, '0014', '红细胞压积', '0', '0-100', 10, '2', null, '红细胞压积');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (42, '0015', '平均红细胞体积', '0', '0-100', 10, '2', null, '平均红细胞体积');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (43, '0016', '平均红细胞血红蛋白含量', '0', '0-100', 10, '2', null, '平均红细胞血红蛋白含量');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (44, '0017', '平均红细胞血红蛋白浓度', '0', '0-100', 10, '2', null, '平均红细胞血红蛋白浓度');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (45, '0018', '红细胞分布宽度-变异系数', '0', '0-100', 10, '2', null, '红细胞分布宽度-变异系数');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (46, '0019', '血小板计数', '0', '0-100', 10, '2', null, '血小板计数');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (47, '0020', '平均血小板体积', '0', '0-100', 10, '2', null, '平均血小板体积');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (48, '0021', '血小板分布宽度', '0', '0-100', 10, '2', null, '血小板分布宽度');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (49, '0022', '淋巴细胞百分比', '0', '0-100', 10, '2', null, '淋巴细胞百分比');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (50, '0023', '中间细胞百分比', '0', '0-100', 10, '2', null, '中间细胞百分比');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (51, '0024', '中性粒细胞百分比', '0', '0-100', 10, '2', null, '中性粒细胞百分比');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (52, '0025', '淋巴细胞绝对值', '0', '0-100', 10, '2', null, '淋巴细胞绝对值');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (53, '0026', '中间细胞绝对值', '0', '0-100', 10, '2', null, '中间细胞绝对值');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (54, '0027', '中性粒细胞绝对值', '0', '0-100', 10, '2', null, '中性粒细胞绝对值');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (55, '0028', '红细胞分布宽度-标准差', '0', '0-100', 10, '2', null, '红细胞分布宽度-标准差');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (56, '0029', '血小板压积', '0', '0-100', 10, '2', null, '血小板压积');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (57, '0030', '尿比重', '0', '0-100', 10, '2', null, '尿比重');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (58, '0031', '尿酸碱度', '0', '0-100', 10, '2', null, '尿酸碱度');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (59, '0032', '尿白细胞', '0', '0-100', 10, '2', null, '尿白细胞');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (60, '0033', '尿亚硝酸盐', '0', '0-100', 10, '2', null, '尿亚硝酸盐');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (61, '0034', '尿蛋白质', '0', '0-100', 10, '2', null, '尿蛋白质');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (62, '0035', '尿糖', '0', '0-100', 10, '2', null, '尿糖');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (63, '0036', '尿酮体', '0', '0-100', 10, '2', null, '尿酮体');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (64, '0037', '尿胆原', '0', '0-100', 10, '2', null, '尿胆原');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (65, '0038', '尿胆红素', '0', '0-100', 10, '2', null, '尿胆红素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (66, '0039', '尿隐血', '0', '0-100', 10, '2', null, '尿隐血');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (67, '0040', '尿镜检红细胞', '0', '0-100', 10, '2', null, '尿镜检红细胞');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (68, '0041', '尿镜检白细胞', '0', '0-100', 10, '2', null, '尿镜检白细胞');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (69, '0042', '上皮细胞', '0', '0-100', 10, '2', null, '上皮细胞');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (70, '0043', '无机盐类', '0', '0-100', 10, '2', null, '无机盐类');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (71, '0044', '尿镜检蛋白定性', '0', '0-100', 10, '2', null, '尿镜检蛋白定性');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (72, '0045', '丙氨酸氨基转移酶', '0', '0-100', 10, '2', null, '丙氨酸氨基转移酶');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (73, '0046', '天门冬氨酸氨基转移酶', '0', '0-100', 10, '2', null, '天门冬氨酸氨基转移酶');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (74, '0047', 'Y-谷氨酰转移酶', '0', '0-100', 10, '2', null, 'Y-谷氨酰转移酶');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (75, '0048', '尿素', '0', '0-100', 10, '2', null, '尿素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (76, '0049', '肌酐', '0', '0-100', 10, '2', null, '肌酐');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (77, '0050', '尿酸', '0', '0-100', 10, '2', null, '尿酸');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (78, '0051', '总胆固醇', '0', '0-100', 10, '2', null, '总胆固醇');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (79, '0052', '甘油三酯', '0', '0-100', 10, '2', null, '甘油三酯');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (80, '0053', '高密度脂蛋白胆固醇', '0', '0-100', 10, '2', null, '高密度脂蛋白胆固醇');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (81, '0054', '低密度脂蛋白胆固醇', '0', '0-100', 10, '2', null, '低密度脂蛋白胆固醇');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (82, '0055', '磷酸肌酸激酶', '0', '0-100', 10, '2', null, '磷酸肌酸激酶');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (83, '0056', '磷酸肌酸激酶同工酶', '0', '0-100', 10, '2', null, '磷酸肌酸激酶同工酶');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (84, '0057', '乳酸脱氢酶', '0', '0-100', 10, '2', null, '乳酸脱氢酶');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (85, '0058', '三碘甲状腺原氨酸', '0', '0-100', 10, '2', null, '三碘甲状腺原氨酸');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (86, '0059', '甲状腺素', '0', '0-100', 10, '2', null, '甲状腺素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (87, '0060', '促甲状腺激素', '0', '0-100', 10, '2', null, '促甲状腺激素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (88, '0061', '子宫', '2', '0-100', 10, '2', null, '子宫');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (89, '0062', '附件', '2', '0-100', 10, '2', null, '附件');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (90, '0063', '总胆红素', '0', '0-100', 10, '2', null, '总胆红素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (91, '0064', '直接胆红素', '0', '0-100', 10, '2', null, '直接胆红素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (92, '0065', '间接胆红素', '0', '0-100', 10, '2', null, '间接胆红素');
INSERT INTO health.t_checkitem (id, code, name, sex, age, price, type, attention, remark) VALUES (94, '00068', '测试', '0', '0-100', 10000000, '1', null, null);